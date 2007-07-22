package au.net.netstorm.boost.util.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DefaultArrayOperator implements ArrayOperator {
    public Object[] minus(Object[] superSetArray, Object[] subSetArray) {
        Set result = convertToSet(superSetArray);
        Set subSet = convertToSet(subSetArray);
        result.removeAll(subSet);
        Object[] type = determineElementType(superSetArray);
        return result.toArray(type);
    }

    public byte[] add(byte[] array1, byte[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        byte[] concatenation = new byte[length1 + length2];
        System.arraycopy(array1, 0, concatenation, 0, length1);
        System.arraycopy(array2, 0, concatenation, length1, length2);
        return concatenation;
    }

    private Set convertToSet(Object[] array) {
        List list = Arrays.asList(array);
        return new HashSet(list);
    }

    private Object[] determineElementType(Object[] array) {
        Class arrayClass = array.getClass();
        Class componentType = arrayClass.getComponentType();
        return (Object[]) Array.newInstance(componentType, 0);
    }
}
