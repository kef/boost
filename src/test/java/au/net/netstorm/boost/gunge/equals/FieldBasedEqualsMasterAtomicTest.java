package au.net.netstorm.boost.gunge.equals;

import au.net.netstorm.boost.nursery.gunge.equals.FieldBasedEqualsMaster;
import au.net.netstorm.boost.sniper.core.BoooostCase;// NOTE: Careful when refactoring due to heavy use of equals!

// DEBT ClassDataAbstractionCoupling {

public class FieldBasedEqualsMasterAtomicTest extends BoooostCase {
    private final EqualsMaster master = new FieldBasedEqualsMaster();
    private static final Integer INTEGER = new Integer(1);
    private static final String STRING = new String("test");

    public void testNullParams() {
        checkEquals(true, null, null);
        checkEquals(false, null, STRING);
        checkEquals(false, STRING, null);
    }

    public void testStringEquals() {
        checkEquals(true, "HI", "HI");
        checkEquals(false, "HI", "THERE");
    }

    public void testDifferentObjects() {
        checkEquals(false, STRING, INTEGER);
    }

    public void testObjectsEqual() {
        TestObject o1 = new TestObject("test", 1);
        TestObject o2 = new TestObject("test", 1);
        checkEquals(true, o1, o2);
    }

    public void testObjectsNotEqual() {
        TestObject o1 = new TestObject("test", 1);
        TestObject o2 = new TestObject("test", 2);
        checkEquals(false, o1, o2);
    }

    public void testNotEqualsTriangulate() {
        TestObject o1 = new TestObject("hello", 5);
        TestObject o2 = new TestObject("there", 5);
        checkEquals(false, o1, o2);
    }

    public void testDifferentClasses() {
        TestObject o1 = new TestObject("test", 1);
        AnotherTestObject o2 = new AnotherTestObject("test", 1);
        checkEquals(false, o1, o2);
    }

    public void testSubClassesDifferent() {
        TestObject o1 = new TestObject("test", 1);
        SubClassTestObject o2 = new SubClassTestObject("test", 1);
        checkEquals(false, o1, o2);
    }

    public void testByteArraysEqual() {
        checkByteArrays(true, "luke", "luke");
        checkByteArrays(false, "luke", "lukeskywalker");
        checkByteArrays(false, "luke", "lu");
    }

    public void testIntArraysEqual() {
        int[] intArray = new int[]{1};
        IntArrayTestObject o1 = new IntArrayTestObject(intArray);
        IntArrayTestObject o2 = new IntArrayTestObject(intArray);
        checkEquals(true, o1, o2);
    }

    public void testObjectArrayEquals() {
        ObjectArrayTestObject o1 = new ObjectArrayTestObject(new Object[]{"x", "y"});
        ObjectArrayTestObject o2 = new ObjectArrayTestObject(new Object[]{"x", "y"});
        checkEquals(true, o1, o2);
    }

    private void checkByteArrays(boolean expected, String firstString, String secondString) {
        ByteArrayTestObject o1 = new ByteArrayTestObject(firstString.getBytes());
        ByteArrayTestObject o2 = new ByteArrayTestObject(secondString.getBytes());
        checkEquals(expected, o1, o2);
    }

    private void checkEquals(boolean expected, Object o1, Object o2) {
        assertEquals(expected, master.equals(o1, o2));
        assertEquals(expected, master.equals(o2, o1));
    }
}
// } DEBT ClassDataAbstractionCoupling
