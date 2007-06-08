package au.net.netstorm.boost.type.util.core;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import au.net.netstorm.boost.type.strong.DefaultIntegerHolder;
import au.net.netstorm.boost.type.strong.IntegerHolder;

public final class DefaultTypeUtility implements TypeUtility {
    public int[] toIntArray(List integerList) {
        Object[] integers = integerList.toArray();
        int[] result = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            Object integer = integers[i];
            result[i] = Integer.parseInt((String) integer);
        }
        return result;
    }

    public int[] toIntArray(String[] strings) {
        int length = strings.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(strings[i]);
        }
        return result;
    }

    public int[] toIntArray(String str) {
        int intValue = Integer.parseInt(str);
        return new int[]{intValue};
    }

    public IntegerHolder[] toIntHolderArray(int[] ints) {
        int length = ints.length;
        IntegerHolder[] intHolder = new DefaultIntegerHolder[length];
        for (int i = 0; i < length; i++) {
            intHolder[i] = new DefaultIntegerHolder(ints[i]);
        }
        return intHolder;
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

    public boolean arrayContainsDuplicates(Object[] array) {
        Set set = new HashSet(Arrays.asList(array));
        return set.size() != array.length;
    }

    public boolean toBoolean(String value) {
        if ("true".equals(value)) return true;
        if ("on".equals(value)) return true;
        return false;
    }

    private int toInt(byte[] bytes) {
        BigInteger bigInteger = new BigInteger(bytes);
        return bigInteger.intValue();
    }
}
