package au.net.netstorm.boost.time.type;

import junit.framework.Assert;
import junit.framework.TestCase;

public final class MinuteOfHourAtomicTest extends TestCase {

    public void testMinutesInHour() {
        Assert.assertEquals(60, MinuteOfHour.MINUTES_IN_HOUR);
    }

    public void testConstants() {
        assertEquals(new MinuteOfHour(0) , MinuteOfHour.FIRST);
    }

    public void testInvalidMinutes() {
        assertInvalidMinute(-1);
        assertInvalidMinute(60);
    }

    public void testMinutes() {
        for (int i=0; i < MinuteOfHour.MINUTES_IN_HOUR; i++) {
            assertEquals(i, new MinuteOfHour(i).value);
        }
    }

    public void testEquality() {
        MinuteOfHour minute = new MinuteOfHour(57);
        assertFalse(minute.equals(null));
        assertFalse(minute.equals(void.class));
        assertNotEquals(minute, new MinuteOfHour(9));
        assertEquals(minute, new MinuteOfHour(57));
    }

    public void testHashCode() {
        assertEquals(100, new MinuteOfHour(12) .hashCode());
    }

    // ---------- PRIVATE:

    private void assertNotEquals(MinuteOfHour m1, MinuteOfHour m2) {
        assertFalse(m1.equals(m2));
        assertFalse(m2.equals(m1));
    }

    private void assertInvalidMinute(int minute) {
        try {
            new MinuteOfHour(minute);
            fail();
        } catch (IllegalArgumentException ex) { }
    }
}
