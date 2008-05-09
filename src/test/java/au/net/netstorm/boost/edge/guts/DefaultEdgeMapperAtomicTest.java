package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

// FIX 2328 reinstate me when implemented
public class DefaultEdgeMapperAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeMapper subject;
    EdgeNameMapper mapperMock;

    public void setUpFixtures() {
//        subject = new DefaultEdgeMapper();
    }

    public void testStaticEdgeToReal() {
    }

    public void testEdgeToReal() {
    }

    public void testRealToEdge() {
    }
}
