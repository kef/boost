package au.net.netstorm.boost.nursery.type;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultAsciiBytesAtomicTest extends InteractionTestCase {
    AsciiBytes subject;
    byte[] bytes;

    public void testConstructor() {
        subject = new DefaultAsciiBytes(bytes);
        byte[] actual = subject.getValue();
        assertEquals(bytes, actual);
    }

    public void testConstructorFailure() {
        try {
            subject = new DefaultAsciiBytes(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
