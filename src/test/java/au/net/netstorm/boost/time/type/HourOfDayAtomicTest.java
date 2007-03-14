package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.test.automock.BoooostCase;

public final class HourOfDayAtomicTest extends BoooostCase {
    public void testHoursInDay() {
        assertEquals(24, HourOfDay.HOURS_IN_A_DAY);
    }

    public void testInvalidHours() {
        assertInvalidHour(-1);
        assertInvalidHour(24);
    }

    public void testHours() {
        for (int i = 0; i < HourOfDay.HOURS_IN_A_DAY; i++) {
            assertEquals(i, new HourOfDay(i).value);
        }
    }

    public void testConstants() {
        assertEquals(new HourOfDay(0), HourOfDay.FIRST);
        assertEquals(HourOfDay.FIRST, HourOfDay.MIDNIGHT);
        assertEquals(new HourOfDay(12), HourOfDay.MIDDAY);
    }

    private void assertInvalidHour(int hour) {
        try {
            new HourOfDay(hour);
            fail();
        } catch (IllegalArgumentException ex) { }
    }
}
