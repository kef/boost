package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.gunge.core.BoooostCase;

public final class SecondOfMinuteAtomicTest extends BoooostCase {
    public void testSecondOfMinute() {
        assertEquals(60, SecondOfMinute.SECONDS_IN_MINUTE);
    }

    public void testInvalidSecond() {
        assertInvalidSecond(-1);
        assertInvalidSecond(60);
    }

    public void testSeconds() {
        for (int i = 0; i < SecondOfMinute.SECONDS_IN_MINUTE; i++) {
            assertEquals(i, new SecondOfMinute(i).value);
        }
    }

    public void testConstants() {
        assertEquals(new SecondOfMinute(0), SecondOfMinute.FIRST);
    }

    // FIX SC502 assert/check; decide which pattern to use and be consistent.
    private void assertInvalidSecond(int second) {
        try {
            new SecondOfMinute(second);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
