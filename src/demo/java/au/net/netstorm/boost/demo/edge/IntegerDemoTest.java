package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.scalpel.core.AutoEdger;
import demo.edge.java.lang.Integer;

public class IntegerDemoTest extends EdgeDemooooTest {
    AutoEdger edger;

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
