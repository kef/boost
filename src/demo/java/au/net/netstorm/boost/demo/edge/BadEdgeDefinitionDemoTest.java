package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.scalpel.core.AutoEdger;
import au.net.netstorm.boost.sledge.support.EdgeException;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import demo.edge.bad.java.lang.BadName;
import demo.edge.bad.java.lang.Object;
import demo.edge.bad.pack.age.String;

public class BadEdgeDefinitionDemoTest extends BadEdgeDemooooTest {
    ThrowableMaster thrower;
    AutoEdger edger;

    public void testMethodMissing() {
        Object o = edger.edge(Object.class, new java.lang.Object());
        try {
            o.missing();
            fail();
        } catch (EdgeException e) {
            Throwable real = thrower.rootCause(e);
            assertEquals(true, real instanceof NoSuchMethodException);
        }
    }

    public void testInvalidName() {
        try {
            edger.edge(BadName.class, new java.lang.Object());
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    public void testInvalidPackage() {
        try {
            edger.edge(String.class, "");
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
