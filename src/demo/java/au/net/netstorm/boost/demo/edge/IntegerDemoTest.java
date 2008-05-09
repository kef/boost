package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
//FIX 2328 reinstate when default package mapping implemented
public class IntegerDemoTest extends LifecycleTestCase implements InjectableTest {
//    AutoEdger edger;

    public void testPrimitiveConstruction() {
//        int expected = 5;
//        Integer i = edger.nu(Integer.class, expected);
//        assertEquals(expected, i.intValue());
    }

    // FIX 2328 this has just triggered a thought on a possible gotcha...
    // FIX 2328 there are certain classes where a referential equality is maintained by jdk, see java.lang.Class
    // FIX 2328 is there anything to stop or identify a brain explosion where some one goes (edgeClass1 == edgeClass2)
    // FIX 2328 basically if someone assumes that the edges maintain identity semantics
    public void testEquality() {
//        Integer i1 = edger.nu(Integer.class, 5);
//        Integer i2 = edger.nu(Integer.class, 5);
//        assertEquals(i1, i2);
    }
}
