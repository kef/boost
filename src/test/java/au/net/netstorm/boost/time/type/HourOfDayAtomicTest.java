package au.net.netstorm.boost.time.type;

import junit.framework.TestCase;

public final class HourOfDayAtomicTest extends TestCase {

    public void testHoursInDay() {
        assertEquals(24, HourOfDay.HOURS_IN_A_DAY);
    }

    public void testInvalidHours() {
        assertInvalidHour(-1);
        assertInvalidHour(24);
    }

    public void testHours() {
        for (int i=0; i < HourOfDay.HOURS_IN_A_DAY; i++) {
            assertEquals(i, new HourOfDay(i).value);
        }
    }

    public void testConstants() {
        assertEquals(new HourOfDay(0), HourOfDay.FIRST);
        assertEquals(HourOfDay.FIRST, HourOfDay.MIDNIGHT);
        assertEquals(new HourOfDay(12), HourOfDay.MIDDAY);
    }

    public void testEquality() {
         HourOfDay hour = new HourOfDay(22);
         assertFalse(hour.equals(null));
         assertFalse(hour.equals(void.class));
         assertNotEquals(hour, new HourOfDay(3));
         assertEquals(hour, new HourOfDay(22));
     }

    public void testHashCode() {
        assertEquals(100, new HourOfDay(5) .hashCode());
    }

    // ---------- PRIVATE:

    private void assertNotEquals(HourOfDay h1, HourOfDay h2) {
        assertFalse(h1.equals(h2));
        assertFalse(h2.equals(h1));
    }

    private void assertInvalidHour(int hour) {
        try {
            new HourOfDay(hour);
            fail();
        } catch (IllegalArgumentException ex) { }
    }
}
