package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgeFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, LazyFields {
    AutoEdgeFactory subject;
    Iterable<String> iterMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdgeFactory();
    }

    public void testNewEdge() {
        AutoEdge<Iterable<String>> edged = subject.newEdge(iterMock);
        assertSame(iterMock, edged.unedge());
    }
}
