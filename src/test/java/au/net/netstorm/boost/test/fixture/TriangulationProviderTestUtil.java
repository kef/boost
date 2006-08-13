package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;

// FIX SC600 This tidies up as TestTriangulationProvider is stitched in.
// FIX SC502 Move instances to their respective unit tests (as per POK theory).
// FIX SC502 Interface it.
// FIX SC502 Rename.

public final class TriangulationProviderTestUtil {
    private final TriangulationProvider knownTypes = new TestTriangulationProvider();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    // FIX SC600 Parameter "additional" is not used.
    // FIX SC050 ? Rename occurrences of "additional" to "extra".
    // FIX SC050 BREADCRUMB - Incorporate "additional"
    public Object[] getInstances(Class[] types, TriangulationProvider additional) {
        Object[] params = new Object[types.length];
        for (int i = 0; i < types.length; i++) params[i] = getInstance(types[i]);
        return params;
    }

    // FIX SC600 This goes now.
    public Object getInstance(Constructor constructor, Object[] parameters) {
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }

    private Object getInstance(Class type) {
        return knownTypes.getInstance(type);
    }
}
