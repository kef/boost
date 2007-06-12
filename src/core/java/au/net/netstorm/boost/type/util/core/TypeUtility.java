package au.net.netstorm.boost.type.util.core;

import java.util.List;

public interface TypeUtility {
    int[] toIntArray(List integerList);

    int[] toIntArray(String[] strings);

    int[] toIntArray(String string);

    String toString(byte[] bytes);

    int toInt(String value);

    long toLong(String value);

    boolean arrayContainsDuplicates(Object[] array);

    boolean toBoolean(String value);

    Object[] mergeArrays(Object[] array1, Object[] array2);
}
