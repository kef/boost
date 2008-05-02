package au.net.netstorm.boost.demo.nursery.autoedge;

import au.net.netstorm.boost.nursery.autoedge.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import demo.edge.java.lang.Integer;

public class IntegerDemoTest extends LifecycleTestCase implements InjectableTest {
    private Integer subject;
    AutoEdger edger;

    public void testPrimitiveConstruction() {
        subject = edger.nu(Integer.class, 5);
        java.lang.Integer expected = java.lang.Integer.valueOf(5);
        java.lang.Integer real = subject.unedge();
        assertEquals(expected, real);
    }
}
