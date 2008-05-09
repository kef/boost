package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

// FIX 2328 I am getting sick of implementing these same 4 interfaces over and over
// FIX 2328 I understand it is nice to opt in/out, however a single named type for most common perms would be nice
public class DefaultEdgeMapperAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeMapper subject;
    EdgePackage edgesMock;

    public void setUpFixtures() {
//        subject = new DefaultEdgeMapper();
    }

    public void testEdgeToReal() {
//        String result = subject.edgeToReal("");
    }

    public void testRealToEdge() {

    }
}
