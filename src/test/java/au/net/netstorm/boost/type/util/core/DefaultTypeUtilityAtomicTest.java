package au.net.netstorm.boost.type.util.core;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.type.strong.DefaultStringHolder;
import au.net.netstorm.boost.type.strong.StringHolder;

public final class DefaultTypeUtilityAtomicTest extends InteractionTestCase implements HasSubjects {
    private static final StringHolder ATTRIBUTE_NAME_1 = new DefaultStringHolder("monkey");
    private static final StringHolder ATTRIBUTE_NAME_2 = new DefaultStringHolder("bonobo");
    private static final StringHolder ATTRIBUTE_NAME_3 = new DefaultStringHolder("bonobo");
    private static final Object[] ARRAY_WITH_DUPLICATES = new Object[]{ATTRIBUTE_NAME_1, ATTRIBUTE_NAME_2, ATTRIBUTE_NAME_3};
    private static final Object[] ARRAY_NO_DUPLICATES = new Object[]{ATTRIBUTE_NAME_1, ATTRIBUTE_NAME_2};
    private static final String[] STRINGS_0 = {};
    private static final String[] STRINGS_1 = {"1"};
    private static final String[] STRINGS_2 = {"2", "1"};
    private static final String STRING = "10";
    private static final int[] INTS_0 = new int[]{};
    private static final int[] INTS_1 = new int[]{1};
    private static final int[] INTS_2 = new int[]{2, 1};
    private static final List ARRAY_LIST = new ArrayList();
    private static final int INT_VALUE = 12;
    private static final String INT_VALUE_AS_STRING = String.valueOf(INT_VALUE);
    private static final byte[] POSITIVE_INT_BYTES = new byte[]{127, -128, -128, -128};
    private static final byte[] NEGATIVE_INT_BYTES = new byte[]{-127, -128, -128, -128};
    private static final String POSITIVE_INT_STRING = "2139127936";
    private static final String NEGATIVE_INT_STRING = "-2122284928";
    private static final long BIG_INTEGER = (long) Integer.MAX_VALUE + 1;
    private static final String BIG_INTEGER_STRING = BIG_INTEGER + "";
    private static final String LONG_VALUE_AS_STRING = "" + Long.MAX_VALUE;
    private static final long LONG_VALUE = Long.MAX_VALUE;
    String someString;
    TypeUtility subject;

    static {
        ARRAY_LIST.add("2");
        ARRAY_LIST.add("1");
    }

    public void setupSubjects() {
        subject = new DefaultTypeUtility();
    }

    public void testStringsToInts() {
        checkStringsToInts(INTS_0, STRINGS_0);
        checkStringsToInts(INTS_1, STRINGS_1);
        checkStringsToInts(INTS_2, STRINGS_2);
    }

    public void testStringToInts() {
        int[] result = subject.toIntArray(STRING);
        assertEquals(new int[]{10}, result);
    }

    public void testArrayListToInts() {
        int[] result = subject.toIntArray(ARRAY_LIST);
        assertEquals(INTS_2, result);
    }

    public void testBytesToString() {
        checkBytesToString(POSITIVE_INT_BYTES, POSITIVE_INT_STRING);
        checkBytesToString(NEGATIVE_INT_BYTES, NEGATIVE_INT_STRING);
    }

    public void testStringToInt() {
        int actual = subject.toInt(INT_VALUE_AS_STRING);
        assertEquals(INT_VALUE, actual);
    }

    public void testStringToLong() {
        long actual = subject.toLong(LONG_VALUE_AS_STRING);
        assertEquals(LONG_VALUE, actual);
    }

    public void testStringToIntFailsWhenBiggerThan4Bytes() {
        try {
            subject.toInt(BIG_INTEGER_STRING);
            fail();
        } catch (NumberFormatException expected) { }
    }

    public void testToBoolean() {
        checkToBoolean(true, "on");
        checkToBoolean(true, "true");
        checkToBoolean(false, someString);
    }

    public void testMerge() {
        String[] array1 = {"one", "two"};
        String[] array2 = {"three", "four"};
        String[] expected = {"one", "two", "three", "four"};
        String[] actual = (String[]) subject.mergeArrays(array1, array2);
        assertEquals(expected, actual);
    }

    private void checkToBoolean(boolean expected, String value) {
        boolean actual = subject.toBoolean(value);
        assertEquals(expected, actual);
    }

    public void testArrayContainsDuplicates() {
        checkArrayContainsDuplicates(ARRAY_WITH_DUPLICATES, true);
        checkArrayContainsDuplicates(ARRAY_NO_DUPLICATES, false);
        checkArrayContainsDuplicates(STRINGS_0, false);
    }

    private void checkArrayContainsDuplicates(Object[] array, boolean expected) {
        boolean actual = subject.arrayContainsDuplicates(array);
        assertEquals(expected, actual);
    }

    private void checkBytesToString(byte[] bytes, String expected) {
        String actual = subject.toString(bytes);
        assertEquals(expected, actual);
    }

    private void checkStringsToInts(int[] expected, String[] strings) {
        int[] result = subject.toIntArray(strings);
        assertEquals(expected, result);
    }
}