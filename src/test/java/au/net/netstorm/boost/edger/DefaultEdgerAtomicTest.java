package au.net.netstorm.boost.edger;

import junit.framework.TestCase;
import au.net.netstorm.boost.edger.edge.java.lang.ClassFactory;
import au.net.netstorm.boost.edger.edge.java.lang.Class;

// FIX 1624 This is actually an edge test not atomic.
// FIX 1624 Consider what to do with bloody generics.
// FIX 1624 Maybe what is going on here with Class should be in demo?
public final class DefaultEdgerAtomicTest extends TestCase {

    public void testFactoryEdgification() {
        Edgifier edgifier = new DefaultEdifier();
        ClassFactory classFactory = (ClassFactory) edgifier.edgifyFactory(ClassFactory.class, Class.class);
        classFactory.newInstance();


        // FIX 1624 Complete factory.forName(String class).
        // FIX 1624 Try getInstance() say on a Map.class.
    }
    
    // FIX 1624 Fail if not an interface.
    // FIX 1624 Fail if interface doesn't exist.
    // FIX 1624 Fail if instance method does not exist.
    // FIX 1624 Fail for starters on equals(), hashCode() and toString().
    // FIX 1624 Actually, any method which is not on the interface.
    // FIX 1624 equals().
    // FIX 1624 hashCode()
}
