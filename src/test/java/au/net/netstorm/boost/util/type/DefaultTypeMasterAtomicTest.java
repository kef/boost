package au.net.netstorm.boost.util.type;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultTypeMasterAtomicTest extends InteractionTestCase {
    private static final Class LOLLY_CLASS = JuicyLolly.class;
    TypeMaster subject = new DefaultTypeMaster();
    Interface lollyIface = new DefaultInterface(Lolly.class);
    Interface celeryIface = new DefaultInterface(Celery.class);
    Interface edibleIface = new DefaultInterface(Edible.class);
    Implementation lollyImpl = new DefaultImplementation(LOLLY_CLASS);

    public void testImplementz() {
        check(lollyImpl, lollyIface, true);
    }

    public void testNotImplementz() {
        check(lollyImpl, celeryIface, false);
    }

    public void testNotExtendz() {
        boolean actual = subject.extendz(lollyIface, celeryIface);
        assertEquals(false, actual);
    }

    // FIX BREADCRUMB 1887 Check getAllInterfaces.
    // FIX BREADCRUMB 1887 BBBBBBBBBBBBBBBBBBBBB Rename getInterfaces to getDeclaredInterfaces.
    public void testExtendz() {
        boolean actual = subject.extendz(lollyIface, edibleIface);
        assertEquals(true, actual);
    }

    public void testGetTypes() {
        Interface[] actual = subject.getInterfaces(lollyImpl);
        Interface[] expected = buildInterfaces(LOLLY_CLASS);
        assertEquals(expected, actual);
    }

    private void check(Implementation implementation, Interface iFace, boolean expected) {
        boolean actual = subject.implementz(implementation, iFace);
        assertEquals(expected, actual);
    }

    private Interface[] buildInterfaces(Class implClass) {
        Class[] ifaces = implClass.getInterfaces();
        List result = new ArrayList();
        for (int i = 0; i < ifaces.length; i++) {
            Interface iface = new DefaultInterface(ifaces[i]);
            result.add(iface);
        }
        return (Interface[]) result.toArray(new Interface[]{});
    }
}
