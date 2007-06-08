package au.net.netstorm.boost.type.util.bytes;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultByteArrayConcatenaterAtomicTest extends InteractionTestCase implements HasSubjects {
    ByteArrayConcatenater subject;
    byte[] foo = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC};
    byte[] bar = {(byte) 0xDD, (byte) 0xEE, (byte) 0xFF};
    byte[] expected = {(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF};

    public void setupSubjects() {
        subject = new DefaultByteArrayConcatenater();
    }

    public void testConcatenate() {
        byte[] actual = subject.concatenate(foo, bar);
        assertEquals(expected, actual);
    }
}
