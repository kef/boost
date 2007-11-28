package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultMarkerAtomicTest extends InteractionTestCase implements HasFixtures {
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