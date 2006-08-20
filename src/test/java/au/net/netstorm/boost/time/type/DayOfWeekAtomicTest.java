package au.net.netstorm.boost.time.type;

import junit.framework.TestCase;

import java.util.Calendar;

public final class DayOfWeekAtomicTest extends TestCase {
    public void testValid() {
        assertEquals(Calendar.SUNDAY, new DayOfWeek(Calendar.SUNDAY).value);
        assertEquals(Calendar.MONDAY, new DayOfWeek(Calendar.MONDAY).value);
        assertEquals(Calendar.TUESDAY, new DayOfWeek(Calendar.TUESDAY).value);
        assertEquals(Calendar.WEDNESDAY, new DayOfWeek(Calendar.WEDNESDAY).value);
        assertEquals(Calendar.THURSDAY, new DayOfWeek(Calendar.THURSDAY).value);
        assertEquals(Calendar.FRIDAY, new DayOfWeek(Calendar.FRIDAY).value);
        assertEquals(Calendar.SATURDAY, new DayOfWeek(Calendar.SATURDAY).value);
    }

    public void testInvalid() {
        assertInvalidDay(Calendar.SUNDAY - 1);
        assertInvalidDay(Calendar.SATURDAY + 1);
    }

    public void testDaysInWeek() {
        assertEquals(7, DayOfWeek.DAYS_IN_A_WEEK);
    }

    public void testEquality() {
        DayOfWeek dow = new DayOfWeek(4);
        assertFalse(dow.equals(null));
        assertFalse(dow.equals(void.class));
        assertNotEquals(dow, new DayOfWeek(3));
        assertEquals(dow, new DayOfWeek(4));
    }

    public void testHashCode() {
        assertEquals(100, new DayOfWeek(5).hashCode());
    }

    public void testToString() {
        assertEquals("SUNDAY", new DayOfWeek(Calendar.SUNDAY).toString());
        assertEquals("MONDAY", new DayOfWeek(Calendar.MONDAY).toString());
        assertEquals("TUESDAY", new DayOfWeek(Calendar.TUESDAY).toString());
        assertEquals("WEDNESDAY", new DayOfWeek(Calendar.WEDNESDAY).toString());
        assertEquals("THURSDAY", new DayOfWeek(Calendar.THURSDAY).toString());
        assertEquals("FRIDAY", new DayOfWeek(Calendar.FRIDAY).toString());
        assertEquals("SATURDAY", new DayOfWeek(Calendar.SATURDAY).toString());
    }

    private void assertNotEquals(DayOfWeek d1, DayOfWeek d2) {
        assertFalse(d1.equals(d2));
        assertFalse(d2.equals(d1));
    }

    private void assertInvalidDay(int day) {
        try {
            new DayOfWeek(day);
            fail();
        } catch (IllegalArgumentException ex) { }
    }
}
