package au.net.netstorm.boost.compose;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultComposerAtomicTest extends TestCase {
    private final MockTestInterfaceOne mock1 = new MockTestInterfaceOne();
    private final Composer composer = new DefaultComposer();

    // FIXME: SC521 Check exceptions are thrown across the boundary.
    // FIXME: SC521 Rename.
    // FIXME: SC521 Check implementations cannot change under our feet.  Maybe.  Yes we will need to.
    public void testSingle() {
        mock1.init();
        Interface iface = new Interface(TestInterfaceOne.class);
        Class[] implementations = {};
        Object ref = composer.compose(iface, implementations);
        Object composite = ref;
    }

    // FIXME: SC521 Complete.
//    public void testDouble();
}