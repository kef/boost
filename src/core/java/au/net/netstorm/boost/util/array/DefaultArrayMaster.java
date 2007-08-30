package au.net.netstorm.boost.util.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DefaultArrayMaster implements ArrayMaster {
    public Object[] minus(Object[] minuend, Object[] subtrahend) {
        Set result = set(minuend);
        Set subSet = set(subtrahend);
        result.removeAll(subSet);
        return toArray(result, minuend);
    }

    public Object[] plus(Object[] array1, Object[] array2) {
        List result = list(array1);
        List set = list(array2);
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
        for (int i = 0; i < array.length; i++) {
            if (output.contains(array[i])) return true;
            output.add(array[i]);
        }
        return false;
    }

    public boolean intersects(Object[] o1, Object[] o2) {
        for (int i = 0; i < o1.length; i++) {
            if (contains(o2, o1[i])) return true;
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

    private Object[] toArray(Collection collection, Object[] array) {
        Object[] type = type(array);
        return collection.toArray(type);
    }

    private Object[] type(Object[] array) {
        Class arrayClass = array.getClass();
        Class componentType = arrayClass.getComponentType();
        return (Object[]) Array.newInstance(componentType, 0);
    }
}
