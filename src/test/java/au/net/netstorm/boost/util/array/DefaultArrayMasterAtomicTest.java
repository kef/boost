package au.net.netstorm.boost.util.array;

import java.util.Arrays;
import java.util.List;
import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.LazyFields;

public final class DefaultArrayMasterAtomicTest extends LifecycleTestCase implements LazyFields {
    ArrayMaster subject = new DefaultArrayMaster();
    byte[] foo = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC};
    byte[] bar = {(byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    byte[] foobar = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigfoobar = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigfoobaz = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xFE};
    Byte[] bigBar = {(byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigFoo = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC};
    Byte baz = (byte) 0xFE;
    String[] duplicates = {"Lockyer", "Lewis", "Langer", "Lazarus", "Lewis"};
    String[] noDuplicates = {"Lockyer", "Lewis", "Langer", "Lazarus"};
    String[] left = {"1", "2", "3", "4", "5", "6"};
    String[] middle = {"11", "9", "7", "5"};
    String[] right = {"7", "8", "9", "10", "11", "12"};
    String[] noStrings = new String[]{};
    Integer[] array;

    public void testMinusBytes() {
        Byte[] actual = subject.minus(bigfoobar, bigBar);
        assertBagEquals(bigFoo, actual);
    }

    public void testPlusBytes() {
        byte[] actual = subject.plus(foo, bar);
        assertEquals(foobar, actual);
    }

    public void testPlus() {
        Byte[] actual = subject.plus(bigFoo, bigBar);
        assertEquals(bigfoobar, actual);
        checkType(actual, Byte[].class);
    }

    public void testPlusSingleElement() {
        Byte[] actual = subject.plus(bigFoo, baz);
        assertEquals(bigfoobaz, actual);
        checkType(actual, Byte[].class);
    }

    public void testContains() {
        boolean actual = subject.contains(bigFoo, bigFoo[2]);
        assertEquals(true, actual);
    }

    public void testHasDuplicates() {
        checkHasDuplicates(noStrings, false);
        checkHasDuplicates(duplicates, true);
        checkHasDuplicates(noDuplicates, false);
    }

    public void testRemoveDuplicates() {
        String[] actual = subject.removeDuplicates(duplicates);
        assertBagEquals(noDuplicates, actual);
    }

    public void testIntersects() {
        checkIntersects(left, middle, true);
        checkIntersects(left, right, false);
        checkIntersects(middle, right, true);
    }

    public void testToArray() {
        checkToArray(array);
        checkToArray();
    }

    private <T> void checkToArray(T... elems) {
        List<T> list = Arrays.asList(elems);
        T[] array = subject.toArray(list, (Class<T>) elems.getClass().getComponentType());
        assertEquals(array, elems);
    }

    private void checkIntersects(Object[] o1, Object[] o2, boolean expected) {
        boolean actual = subject.intersects(o1, o2);
        assertEquals(expected, actual);
    }

    private void checkHasDuplicates(Object[] input, boolean expected) {
        boolean actual = subject.hasDuplicates(input);
        assertEquals(expected, actual);
    }

    private void checkType(Object[] actual, Class type) {
        Class arrayType = actual.getClass();
        boolean matches = type.isAssignableFrom(arrayType);
        assertEquals(true, matches);
    }
}
