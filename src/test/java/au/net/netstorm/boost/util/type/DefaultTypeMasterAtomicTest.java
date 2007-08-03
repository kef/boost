package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultTypeMasterAtomicTest extends InteractionTestCase {
    TypeMaster subject = new DefaultTypeMaster();
    Class lollyClass = JuicyLolly.class;
    Interface lollyIface = new DefaultInterface(Lolly.class);
    Interface celeryIface = new DefaultInterface(Celery.class);
    Interface edibleIface = new DefaultInterface(Edible.class);
    Implementation lollyImpl = new DefaultImplementation(lollyClass);

    // FIX BREADCRUMB 1887 Check getAllInterfaces.
    // FIX BREADCRUMB 1887 BBBBBBBBBBBBBBBBBBBBB Rename getInterfaces to getDeclaredInterfaces.

    public void testImplements() {
        checkImplements(lollyImpl, lollyIface, true);
        checkImplements(lollyImpl, edibleIface, true);
        checkImplements(lollyImpl, celeryIface, false);
    }

    public void testExtends() {
        checkExtends(false, lollyIface, celeryIface);
        checkExtends(true, lollyIface, edibleIface);
    }

    public void testInterfaces() {
        Interface[] actual = subject.interfaces(lollyIface);
    }

    public void testDeclaredInterfaces() {
        Interface[] actual = subject.declaredInterfaces(lollyImpl);
        Interface[] expected = {lollyIface};
        assertEquals(expected, actual);
    }

    private void checkExtends(boolean expected, Interface sub, Interface supa) {
        boolean actual = subject.extendz(sub, supa);
        assertEquals(expected, actual);
    }

    private void checkImplements(Implementation implementation, Interface iFace, boolean expected) {
        boolean actual = subject.implementz(implementation, iFace);
        assertEquals(expected, actual);
    }
}
