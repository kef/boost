package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.test.core.BoooostCase;

public final class TimeOfDayAtomicTest extends BoooostCase {
    public static final HourOfDay AN_HOUR = new HourOfDay(3);
    public static final MinuteOfHour A_MINUTE = new MinuteOfHour(42);
    public static final SecondOfMinute A_SECOND = new SecondOfMinute(7);

    public void testNullsInvalidInConstuctor() {
        assertNullsInvalidInConstructor(null, A_MINUTE, A_SECOND);
        assertNullsInvalidInConstructor(AN_HOUR, null, A_SECOND);
        assertNullsInvalidInConstructor(AN_HOUR, A_MINUTE, null);
    }

    public void testConstants() {
        assertConstants(0, 0, 0, TimeOfDay.MIDNIGHT);
        assertConstants(12, 0, 0, TimeOfDay.MIDDAY);
    }

    public void testFields() {
        assertFields(0, 0, 0);
        assertFields(5, 18, 34);
        assertFields(23, 59, 59);
    }

    private void assertConstants(int hour, int minute, int second, TimeOfDay result) {
        TimeOfDay expected = new TimeOfDay(new HourOfDay(hour), new MinuteOfHour(minute), new SecondOfMinute(second));
        assertEquals(expected, result);
    }

    private void assertNullsInvalidInConstructor(HourOfDay hour, MinuteOfHour minute, SecondOfMinute second) {
        try {
            new TimeOfDay(hour, minute, second);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void assertFields(int hour, int minute, int second) {
        HourOfDay hod = new HourOfDay(hour);
        MinuteOfHour moh = new MinuteOfHour(minute);
        SecondOfMinute som = new SecondOfMinute(second);
        TimeOfDay tod = new TimeOfDay(hod, moh, som);
        assertEquals(hod, tod.hour);
        assertEquals(moh, tod.minute);
        assertEquals(som, tod.second);
    }
}
