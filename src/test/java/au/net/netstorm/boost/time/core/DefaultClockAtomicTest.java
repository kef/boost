package au.net.netstorm.boost.time.core;

import au.net.netstorm.boost.edge.java.lang.EdgeSystem;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultClockAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    Clock subject;
    TimePointMaster timeLord;
    TimePoint expected;
    EdgeSystem system;
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Long millis;

    public void setUpFixtures() {
        subject = new DefaultClock();
        inject(subject);
    }

    public void testSubject() {
        expect.oneCall(timeLord, expected, "now", system);
        TimePoint actual = subject.now();
        assertEquals(expected, actual);
    }

    public void testGetTime() {
        expect.oneCall(timeLord, expected, "get", millis);
        TimePoint actual = subject.getTime(millis.longValue());
        assertEquals(expected, actual);
    }

    private void inject(Object ref) {
        fielder.setInstance(ref, "system", system);
        fielder.setInstance(ref, "drWho", timeLord);
    }
}
