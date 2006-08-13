package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;

// FIX SC600 This tidies up as TestTriangulationProvider is stitched in.
// FIX SC502 Move instances to their respective unit tests (as per POK theory).
// FIX SC502 Interface it.
// FIX SC502 Rename.

public final class TriangulationProviderTestUtil {
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    // FIX SC600 This goes now.
    public Object getInstance(Constructor constructor, Object[] parameters) {
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }
}
