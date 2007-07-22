package au.net.netstorm.boost.util.array;

import au.net.netstorm.boost.test.core.BoooostCase;

public final class DefaultArrayOperatorAtomicTest extends BoooostCase {
    byte[] foo = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC};
    byte[] bar = {(byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    byte[] foobar = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigfoobar = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigBar = {(byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    Byte[] bigFoo = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC};
    ArrayOperator subject = new DefaultArrayOperator();

    public void testMinus() {
        Object[] actual = subject.minus(bigfoobar, bigBar);
        assertBagEquals(bigFoo, actual);
    }

    public void testPlus() {
        byte[] actual = subject.add(foo, bar);
        assertEquals(foobar, actual);
    }
}
