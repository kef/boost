package au.net.netstorm.boost.util.typed;

import java.util.List;

public interface TypeUtility {
    int[] convert(List integerList);

    int[] convert(String[] strings);

    int[] convert(String string);

    String toString(byte[] bytes);

    int toInt(String value);

    long toLong(String value);

    boolean hasDuplicates(Object[] array);

    boolean toBoolean(String value);

    Object[] merge(Object[] array1, Object[] array2);

    int toInt(byte[] bytes);
}
