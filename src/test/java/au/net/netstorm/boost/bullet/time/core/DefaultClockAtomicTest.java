package au.net.netstorm.boost.bullet.time.core;

import au.net.netstorm.boost.sledge.java.lang.EdgeSystem;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultClockAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    Clock subject;
    TimePointMaster timeLordMock;
    TimePoint expected;
    EdgeSystem system;
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Long millis;

    public void setUpFixtures() {
        subject = new DefaultClock();
        inject(subject);
    }

    public void testSubject() {
        expect.oneCall(timeLordMock, expected, "now", system);
        TimePoint actual = subject.now();
        assertEquals(expected, actual);
    }

    private void inject(Object ref) {
        fielder.setInstance(ref, "system", system);
        fielder.setInstance(ref, "drWho", timeLordMock);
    }
}
