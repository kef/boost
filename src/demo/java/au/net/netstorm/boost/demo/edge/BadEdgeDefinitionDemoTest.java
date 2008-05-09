package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

//FIX 2328 reinstate when default package mapping implemented
public class BadEdgeDefinitionDemoTest extends LifecycleTestCase implements InjectableTest {
//    AutoEdger edger;

    public void testMethodMissing() {
//        Object o = edger.edge(Object.class, new java.lang.Object());
//        try {
//            o.missing();
//            fail();
//        } catch (EdgeException e) {
//            assertEquals(true, e.causeIs(NoSuchMethodException.class));
//        }
    }

    public void testInvalidName() {
//        try {
//            edger.edge(BadName.class, new java.lang.Object());
//            fail();
//        } catch (IllegalArgumentException expected) { }
    }

    public void testInvalidPackage() {
//        try {
//            edger.edge(String.class, "");
//            fail();
//        } catch (IllegalArgumentException expected) { }
    }

    // FIX 2328 Are there cases where R and E parameters make sense?  How is this dealt with?

    // FIX 2328 MH - do you mean a signature like  edge.foo(edge.java.lang.Integer, java.lang.Integer)
    // FIX 2328 with a target of  real.foo(java.lang.Integer, java.lang.Integer)
    // FIX 2328 if that is the case then it is driven off the declared edge interface and only edges will be unedged

    // FIX 2328 MH - if you mean a target of real.foo(edge.java.lang.Integer, java.lang.Integer)
    // FIX 2328 then it doesn't handle it - pretty trivial change to MethodWarp but I could not
    // FIX 2328 come up with a use case for it.
}
