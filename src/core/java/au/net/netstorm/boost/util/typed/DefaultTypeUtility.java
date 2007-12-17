package au.net.netstorm.boost.util.typed;

import java.lang.reflect.Array;
import java.math.BigInteger;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// FIX DEBT Bit of a trollop.  Knock on the head.
public final class DefaultTypeUtility implements TypeUtility {
    public Integer[] convert(List<String> list) {
        Integer[] result = new Integer[list.size()];
        for (int i = 0; i < result.length; i++) {
            String value = list.get(i);
            result[i] = toInt(value);
        }
        return result;
    }

    public Integer[] convert(String[] strings) {
        List<String> list = asList(strings);
        return convert(list);
    }

    public Integer[] convert(String string) {
        Integer integer = toInt(string);
        return new Integer[]{integer};
    }

    public String toString(byte[] bytes) {
        Integer integer = toInt(bytes);
        return String.valueOf(integer);
    }

    public Integer toInt(String value) {
        return Integer.valueOf(value);
    }

    public Long toLong(String value) {
        return Long.valueOf(value);
    }

    public Boolean hasDuplicates(Object[] array) {
        Set set = new HashSet(asList(array));
        return set.size() != array.length;
    }

    public Boolean toBoolean(String value) {
        if ("true".equalsIgnoreCase(value)) return true;
        if ("on".equalsIgnoreCase(value)) return true;
        return false;
    }

    public <T> T[] concat(T[] a1, T[] a2) {
        Class arrayClass = a1.getClass();
        Class componentClass = arrayClass.getComponentType();
        int mergedArrayLength = a1.length + a2.length;
        T[] merged = (T[]) Array.newInstance(componentClass, mergedArrayLength);
        System.arraycopy(a1, 0, merged, 0, a1.length);
        System.arraycopy(a2, 0, merged, a1.length, a2.length);
        return merged;
    }

    public Integer toInt(byte[] bytes) {
        BigInteger bigInteger = new BigInteger(bytes);
        return bigInteger.intValue();
    }
}
