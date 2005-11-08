package au.net.netstorm.boost.time.type;

import junit.framework.TestCase;

public final class SecondOfMinuteAtomicTest extends TestCase {

    public void testSecondOfMinute() {
        assertEquals(60, SecondOfMinute.SECONDS_IN_MINUTE);
    }

    public void testInvalidSecond() {
        assertInvalidSecond(-1);
        assertInvalidSecond(60);
    }

    public void testSeconds() {
        for (int i=0; i < SecondOfMinute.SECONDS_IN_MINUTE; i++) {
            assertEquals(i, new SecondOfMinute(i).value);
        }
    }

    public void testConstants() {
        assertEquals(new SecondOfMinute(0) , SecondOfMinute.FIRST);
    }

    // FIXME: SC502 assert/check; decide which pattern to use and be consistent.
    private void assertInvalidSecond(int second) {
        try {
            new SecondOfMinute(second);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
