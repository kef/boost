package au.net.netstorm.boost.demo.edge;

import java.util.ArrayList;

import au.net.netstorm.boost.edge.core.AutoEdger;
import demo.edge.java.util.List;

// FIX 2328 Rename.
public final class ListDemoTest extends EdgeDemooooTest {
    AutoEdger edger;

    public void testNuSubType() {
        List<?> edge = edger.nee(List.class, ArrayList.class, 5);
        assertEquals(0, edge.size());
    }
}
