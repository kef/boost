package au.net.netstorm.boost.demo.nursery.autoedge;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.nursery.autoedge.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class AutoEdgeNewObjectDemoTest extends LifecycleTestCase implements InjectableTest {
    AutoEdger edger;

    public void testEdgeCreation() {
        String message = "hello";
        EdgeToBeEdgedClass edge = edger.newEdge(EdgeToBeEdgedClass.class, ToBeEdgedClass.class, message);
        assertEquals(message, edge.edgeMethod());
    }

    public void testEdgeCreationException() {
        try {
            edger.newEdge(EdgeToBeEdgedClass.class, ToBeEdgedClass.class);
        } catch (EdgeException e) { /* expected */ }
    }
}
