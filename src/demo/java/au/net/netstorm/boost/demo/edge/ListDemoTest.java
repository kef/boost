package au.net.netstorm.boost.demo.edge;

import java.util.ArrayList;

import au.net.netstorm.boost.edge.core.AutoEdger;
import demo.edge.java.util.List;

// FIX 2328 Rename.
public final class ListDemoTest extends EdgeDemooooTest {
    AutoEdger edger;

    // FIX 2328 Complete - fill in some more methods etc..
    // FIX 2328 another case for generics.
    public void testNuSubType() {
        List<?> edge = edger.nuImpl(List.class, ArrayList.class, 5);
        assertEquals(0, edge.size());
    }
}
