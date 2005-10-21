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

    public void testEquality() {
        SecondOfMinute second = new SecondOfMinute(49);
        assertFalse(second.equals(null));
        assertFalse(second.equals(void.class));
        assertNotEquals(second, new SecondOfMinute(12));
        assertEquals(second, new SecondOfMinute(49));
    }

    public void testHashCode() {
        assertEquals(100, new SecondOfMinute(5).hashCode());
    }

    // ---------- PRIVATE:

    private void assertNotEquals(SecondOfMinute s1, SecondOfMinute s2) {
        assertFalse(s1.equals(s2));
        assertFalse(s2.equals(s1));
    }

    private void assertInvalidSecond(int second) {
        try {
            new SecondOfMinute(second);
            fail();
        } catch (IllegalArgumentException ex) { }
    }
}
