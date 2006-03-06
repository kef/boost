package au.net.netstorm.boost.compose;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultComposerAtomicTest extends TestCase {
    private final MockTestInterfaceA mockA = new MockTestInterfaceA();
    private final TestInterfaceB mockB = null;
    private final Composer composer = new DefaultComposer();
    // FIXME: SC521 Test failure modes for 0,1, 3 or more composed.

    public void testUnsupported() {
    }

    // FIXME: SC521 Check exceptions are thrown across the boundary.
    // FIXME: SC521 Rename.
    // FIXME: SC521 Check implementations cannot change under our feet.  Maybe.  Yes we will need to.
    public void testDouble() {
        mockA.init();
        Interface iface = new Interface(TestInterfaceA.class);
        Object[] implementations = {mockA, mockB};
        Object ref = composer.compose(iface, implementations);
        TestInterfaceA composite = (TestInterfaceA) ref;
        // FIXME: SC521 BREADCRUMB reinstate.
//        assertNotNull(composite);
//        composite.call();
    }

    // FIXME: SC521 Complete.
//    public void testDouble();
}