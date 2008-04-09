package au.net.netstorm.boost.gunge.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import au.net.netstorm.boost.gunge.collection.CollectionMaster;
import au.net.netstorm.boost.gunge.collection.DefaultCollectionMaster;

public final class DefaultArrayMaster implements ArrayMaster {
    CollectionMaster collections = new DefaultCollectionMaster();

    public <T> T[] minus(T[] minuend, T... subtrahend) {
        Set<T> result = collections.mutableSet(minuend);
        Set<T> subSet = collections.immutableSet(subtrahend);
        result.removeAll(subSet);
        return toArray(result, minuend);
    }

    public <T> T[] plus(T[] array1, T... array2) {
        List<T> result = collections.mutableList(array1);
        List<T> set = collections.immutableList(array2);
        result.addAll(set);
        return toArray(result, array1);
    }

    public byte[] plus(byte[] array1, byte[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        byte[] concatenation = new byte[length1 + length2];
        System.arraycopy(array1, 0, concatenation, 0, length1);
        System.arraycopy(array2, 0, concatenation, length1, length2);
        return concatenation;
    }

    public boolean contains(Object[] array, Object o) {
        List result = collections.immutableList(array);
        return result.contains(o);
    }

    public boolean hasDuplicates(Object[] array) {
        List output = new ArrayList();
        for (Object obj : array) {
            if (output.contains(obj)) return true;
            output.add(obj);
        }
        return false;
    }

    public <T> T[] removeDuplicates(T[] array) {
        Set<T> set = collections.immutableSet(array);
        return toArray(set, array);
    }

    public boolean intersects(Object[] o1, Object[] o2) {
        for (Object obj : o1) {
            if (contains(o2, obj)) return true;
        }
        return false;
    }

    public Object[] toArray(Collection collection) {
        return toArray(collection, Object.class);
    }

    public <T> T[] toArray(Collection<T> collection, Class<T> componentType) {
        T[] array = (T[]) Array.newInstance(componentType, collection.size());
        return collection.toArray(array);
    }

    private <T> T[] toArray(Collection<T> collection, T[] array) {
        Class<T> componentType = componentType(array);
        return toArray(collection, componentType);
    }

    private <T> Class<T> componentType(T[] array) {
        Class arrayClass = array.getClass();
        return arrayClass.getComponentType();
    }
}
