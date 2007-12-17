package au.net.netstorm.boost.util.typed;

import java.util.List;

public interface TypeUtility {
    Integer[] convert(List<String> list);

    Integer[] convert(String[] strings);

    Integer[] convert(String string);

    String toString(byte[] bytes);

    Integer toInt(byte[] bytes);

    Integer toInt(String value);

    Long toLong(String value);

    Boolean toBoolean(String value);

    Boolean hasDuplicates(Object[] array);

    <T> T[] concat(T[] a1, T[] a2);
}
