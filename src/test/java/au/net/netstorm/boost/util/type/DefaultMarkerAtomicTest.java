package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class DefaultMarkerAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    Marker subject;

    public void setUpFixtures() {
        subject = new DefaultMarker();
    }

    public void testIsMarker() {
        Lolly lolly = new JuicyLolly();
        checkIsMarker(true, lolly, Juicy.class);
        checkIsMarker(false, lolly, Soldier.class);
    }

    private void checkIsMarker(boolean expected, Object ref, Class iface) {
        boolean actual = subject.is(ref, iface);
        assertEquals(expected, actual);
    }
}