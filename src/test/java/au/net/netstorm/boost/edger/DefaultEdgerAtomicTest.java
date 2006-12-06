package au.net.netstorm.boost.edger;

import junit.framework.TestCase;
import au.net.netstorm.boost.edger.edge.java.lang.ClassFactory;

// FIX 1624 This is actually an edge test not atomic.
// FIX 1624 Maybe what is going on here with Class should be in demo?
public final class DefaultEdgerAtomicTest extends TestCase {

    public void testFactoryEdgification() {
        Edgifier edgifier = new DefaultEdifier();
        Object edge = edgifier.edgifyFactory(ClassFactory.class);
        // FIX 1624 Complete factory.newInstance().
    }

    // FIX 1624 Fail if not an interface.
    // FIX 1624 Fail if doesn't exist.
}
