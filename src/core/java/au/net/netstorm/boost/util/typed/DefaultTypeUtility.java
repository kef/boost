package au.net.netstorm.boost.util.typed;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DefaultTypeUtility implements TypeUtility {
    public int[] convert(List integerList) {
        Object[] integers = integerList.toArray();
        int[] result = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            Object integer = integers[i];
            result[i] = Integer.parseInt((String) integer);
        }
        return result;
    }

    public int[] convert(String[] strings) {
        int length = strings.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(strings[i]);
        }
        return result;
    }

    public int[] convert(String str) {
        int intValue = Integer.parseInt(str);
        return new int[]{intValue};
    }

    public String toString(byte[] bytes) {
        int intValue = toInt(bytes);
        return String.valueOf(intValue);
    }

    public int toInt(String value) {
        return Integer.parseInt(value);
    }

    public long toLong(String value) {
        return Long.parseLong(value);
    }

    public boolean hasDuplicates(Object[] array) {
        Set set = new HashSet(Arrays.asList(array));
        return set.size() != array.length;
    }

    public boolean toBoolean(String value) {
        if ("true".equals(value)) return true;
        if ("on".equals(value)) return true;
        return false;
    }

    public Object[] merge(Object[] array1, Object[] array2) {
        Class arrayClass = array1.getClass();
        Class componentClass = arrayClass.getComponentType();
        int mergedArrayLength = array1.length + array2.length;
        Object[] merged = (Object[]) Array.newInstance(componentClass, mergedArrayLength);
        System.arraycopy(array1, 0, merged, 0, array1.length);
        System.arraycopy(array2, 0, merged, array1.length, array2.length);
        return merged;
    }

    public int toInt(byte[] bytes) {
        BigInteger bigInteger = new BigInteger(bytes);
        return bigInteger.intValue();
    }
}
