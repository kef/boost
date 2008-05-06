package au.net.netstorm.boost.bullet.time.type;

import au.net.netstorm.boost.sniper.core.BoooostCase;
import junit.framework.Assert;

public final class MinuteOfHourAtomicTest extends BoooostCase {
    public void testMinutesInHour() {
        Assert.assertEquals(60, MinuteOfHour.MINUTES_IN_HOUR);
    }

    public void testConstants() {
        assertEquals(new MinuteOfHour(0), MinuteOfHour.FIRST);
    }

    public void testInvalidMinutes() {
        assertInvalidMinute(-1);
        assertInvalidMinute(60);
    }

    public void testMinutes() {
        for (int i = 0; i < MinuteOfHour.MINUTES_IN_HOUR; i++) {
            assertEquals(i, new MinuteOfHour(i).value);
        }
    }

    private void assertInvalidMinute(int minute) {
        try {
            new MinuteOfHour(minute);
            fail();
        } catch (IllegalArgumentException ex) { }
    }
}
