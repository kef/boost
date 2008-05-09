package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.edge.core.AutoEdger;
import au.net.netstorm.boost.edge.guts.EdgePackage;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import au.net.netstorm.boost.spider.registry.Registry;
import demo.edge.java.lang.Integer;
public class IntegerDemoTest extends LifecycleTestCase implements OverlaysWeb, InjectableTest {
    AutoEdger edger;
    Registry registry;

    // FIX 2328 not required in normal (non-demo) case, maybe pull out of demo test somehow?
    public void overlay(Registry registry) {
        registry.single(EdgePackage.class, DemoEdgePackage.class);
    }

    public void testPrimitiveConstruction() {
        int expected = 5;
        Integer i = edger.nu(Integer.class, expected);
        assertEquals(expected, i.intValue());
    }

    public void testEquality() {
        Integer i1 = edger.nu(Integer.class, 5);
        Integer i2 = edger.nu(Integer.class, 5);
        assertEquals(i1, i2);
    }
}
