package au.net.netstorm.boost.demo.nursery.autoedge;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.nursery.autoedge.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import demo.edge.bad.java.lang.BadName;
import demo.edge.bad.java.lang.Object;
import demo.edge.bad.pack.age.String;

public class BadEdgeDefinitionDemoTest extends LifecycleTestCase implements InjectableTest {
    AutoEdger edger;

    public void testMethodMissing() {
        Object o = edger.edge(Object.class, new java.lang.Object());
        try {
            o.missing();
            fail();
        } catch (EdgeException e) {
            assertEquals(true, e.causeIs(NoSuchMethodException.class));
        }
    }

    public void testInvalidName() {
        try {
            edger.edge(BadName.class, new java.lang.Object());
            fail();
        } catch (IllegalArgumentException e) { /* expected */ }
    }

    public void testInvalidPackage() {
        try {
            edger.edge(String.class, "");
            fail();
        } catch (IllegalArgumentException e) { /* expected */ }
    }
}
