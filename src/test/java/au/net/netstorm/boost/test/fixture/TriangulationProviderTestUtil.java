package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

// FIX SC600 This tidies up as TestTriangulationProvider is stitched in.
// FIX SC502 Move instances to their respective unit tests (as per POK theory).
// FIX SC502 Interface it.
// FIX SC502 Rename.

public final class TriangulationProviderTestUtil {
    private final TriangulationProvider knownTypes = new TestTriangulationProvider();

    // FIX SC600 Parameter "additional" is not used.
    // FIX SC050 ? Rename occurrences of "additional" to "extra".
    // FIX SC050 BREADCRUMB - Incorporate "additional"
    public Object[] getInstances(Class[] types, TriangulationProvider additional) {
        Object[] params = new Object[types.length];
        for (int i = 0; i < types.length; i++) params[i] = getInstance(types[i]);
        return params;
    }

    public Object getInstance(Constructor constructor, Object[] parameters) {
        try {
            // FIX SC523 Edge class exists now, use it. Is the exception message below meaningful?
            // FIX SC050 ? use an edge class.
            constructor.setAccessible(true);
            return constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new RuntimeException("Constructor does not match expected.", e);
            // FIX SC050 This is NOT always the case.  If the object throws ANY exception in the constructor, this will be reported.  FIX!!!
            // FIX SC050 Ensure ALL Mock* are serializable.  Required if they are to be used in testing DATA objects which in turn may need to be serializable.
        }
    }

    private Object getInstance(Class type) {
        return knownTypes.getInstance(type);
    }
}
