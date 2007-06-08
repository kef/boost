package au.net.netstorm.boost.type.util.core;

import java.util.List;
import au.net.netstorm.boost.type.strong.IntegerHolder;

public interface TypeUtility {
    int[] toIntArray(List integerList);

    int[] toIntArray(String[] strings);

    int[] toIntArray(String string);

    IntegerHolder[] toIntHolderArray(int[] ints);

    String toString(byte[] bytes);

    int toInt(String value);

    long toLong(String value);

    boolean arrayContainsDuplicates(Object[] array);

    boolean toBoolean(String value);
}
