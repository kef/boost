package au.net.netstorm.boost.util.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DefaultArrayMaster implements ArrayMaster {
    public <T> T[] minus(T[] minuend, T... subtrahend) {
        Set<T> result = set(minuend);
        Set<T> subSet = set(subtrahend);
        result.removeAll(subSet);
        return toArray(result, minuend);
    }

    public <T> T[] plus(T[] array1, T... array2) {
        List<T> result = list(array1);
        List<T> set = list(array2);
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
        List result = list(array);
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
        Set<T> set = set(array);
        return toArray(set, array);
    }

    public boolean intersects(Object[] o1, Object[] o2) {
        for (Object obj : o1) {
            if (contains(o2, obj)) return true;
        }
        return false;
    }

    private Set set(Object[] array) {
        List list = list(array);
        return new HashSet(list);
    }

    private List list(Object[] array) {
        List immutable = Arrays.asList(array);
        return new ArrayList(immutable);
    }

    private <T> T[] toArray(Collection<T> collection, T[] array) {
        T[] type = type(array);
        return collection.toArray(type);
    }

    private <T> T[] type(T[] array) {
        Class arrayClass = array.getClass();
        Class componentType = arrayClass.getComponentType();
        return (T[]) Array.newInstance(componentType, 0);
    }
}
