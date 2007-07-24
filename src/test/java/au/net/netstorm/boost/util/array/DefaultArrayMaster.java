package au.net.netstorm.boost.util.array;

import java.lang.reflect.Array;
import java.util.Arrays;
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
        Set result = set(array1);
        Set set = set(array2);
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

    private Set set(Object[] array) {
        List list = Arrays.asList(array);
        return new HashSet(list);
    }

    private Object[] toArray(Set set, Object[] typedArray) {
        Object[] type = type(typedArray);
        return set.toArray(type);
    }

    private Object[] type(Object[] array) {
        Class arrayClass = array.getClass();
        Class componentType = arrayClass.getComponentType();
        return (Object[]) Array.newInstance(componentType, 0);
    }
}
