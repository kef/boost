package au.net.netstorm.boost.util.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultTypeMasterAtomicTest extends InteractionTestCase {
    private static final Class IMPL_CLASS = ArrayList.class;
    TypeMaster subject = new DefaultTypeMaster();
    Interface listIFace = new DefaultInterface(List.class);
    Interface otherIface = new DefaultInterface(MyInterface.class);
    Implementation impl = new DefaultImplementation(IMPL_CLASS);
    Interface superIface = new DefaultInterface(Collection.class);

    public void testImplementz() {
        check(impl, listIFace, true);
    }

    public void testNotImplementz() {
        check(impl, otherIface, false);
    }

    public void testNotExtendz() {
        boolean actual = subject.extendz(listIFace, otherIface);
        assertEquals(false, actual);
    }

    // FIX BREADCRUMB 1887 Check getAllInterfaces.
    // FIX BREADCRUMB 1887 BBBBBBBBBBBBBBBBBBBBB Rename getInterfaces to getDeclaredInterfaces.
    public void testExtendz() {
        boolean actual = subject.extendz(listIFace, superIface);
        assertEquals(true, actual);
    }

    public void testGetTypes() {
        Interface[] actual = subject.getInterfaces(impl);
        Interface[] expected = buildInterfaces(IMPL_CLASS);
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

    private static interface MyInterface {
    }
//    private static class MyClass{}
}
