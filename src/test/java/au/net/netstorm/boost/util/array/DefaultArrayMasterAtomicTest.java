package au.net.netstorm.boost.util.array;

import au.net.netstorm.boost.test.core.BoooostCase;

public final class DefaultArrayMasterAtomicTest extends BoooostCase {
    byte[] foo = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC};
    byte[] bar = {(byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    byte[] foobar = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigfoobar = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigBar = {(byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigFoo = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC};
    String[] duplicates = {"Lockyer", "Lewis", "Langer", "Lazarus", "Lewis"};
    String[] noDuplicates = {"Lockyer", "Lewis", "Langer", "Lazarus"};
    ArrayMaster subject = new DefaultArrayMaster();
    private String[] noStrings = new String[]{};

    public void testMinusBytes() {
        Object[] actual = subject.minus(bigfoobar, bigBar);
        assertBagEquals(bigFoo, actual);
    }

    public void testPlusBytes() {
        byte[] actual = subject.plus(foo, bar);
        assertEquals(foobar, actual);
    }

    public void testPlus() {
        Object[] actual = subject.plus(bigFoo, bigBar);
        assertEquals(bigfoobar, actual);
        checkType(actual, Byte[].class);
    }

    public void testContains() {
        boolean actual = subject.contains(bigFoo, bigFoo[2]);
    }

    public void testHasDuplicates() {
        checkHasDuplicates(noStrings, false);
        checkHasDuplicates(duplicates, true);
        checkHasDuplicates(noDuplicates, false);
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
