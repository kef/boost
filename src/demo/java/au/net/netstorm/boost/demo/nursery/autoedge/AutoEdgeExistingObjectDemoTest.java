package au.net.netstorm.boost.demo.nursery.autoedge;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.nursery.autoedge.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class AutoEdgeExistingObjectDemoTest extends LifecycleTestCase implements HasFixtures, InjectableTest {
    private ToBeEdgedObject target;
    AutoEdger edger;

    public void setUpFixtures() {
        target = new ToBeEdgedObject();
    }

    public void testEdgeExistingObject() {
        EdgeToBeEdgedObject edge = edger.edge(EdgeToBeEdgedObject.class, target);
        assertEquals(target.getState(), edge.getState());
    }

    public void testEdgeMethodException() {
        EdgeToBeEdgedObject edge = edger.edge(EdgeToBeEdgedObject.class, target);
        try {
            edge.setState("bad");
            fail("expected edge exception");
        } catch (EdgeException e) {
//            FIXME see suggestion in DefaultEdgeMethod
//            assertEquals(Exception.class, e.getCause());
        }
    }

    public void testEdgeStateChange() {
        EdgeToBeEdgedObject edge = edger.edge(EdgeToBeEdgedObject.class, target);
        String newState = "new";
        edge.setState(newState);
        assertEquals(newState, edge.getState());
    }
}
