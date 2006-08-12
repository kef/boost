package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;

// FIX SC600 This tidies up as TestTriangulationProvider is stitched in.
// FIX SC502 Move instances to their respective unit tests (as per POK theory).
// FIX SC502 Interface it.
// FIX SC502 Rename.

public final class TriangulationProviderTestUtil {
    private final ReflectMaster reflectMaster = new DefaultReflectMaster();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final TriangulationProvider knownTypes = new TestTriangulationProvider();

    // FIX SC050 ? Rename occurrences of "additional" to "extra".
    // FIX SC050 BREADCRUMB - Incorporate "additional"
    public Object[] getInstances(Class[] types, TriangulationProvider additional) {
        Object[] params = new Object[types.length];
        for (int i = 0; i < types.length; i++) params[i] = getInstance(types[i], additional);
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

    private Object getInstance(Class type, TriangulationProvider additional) {
        return knownTypes.getInstance(type);
    }

    // FIX BREADCRUMB A whole bunch of code goes.  Follow the yellow.

    private Object getArrayInstance(Class type) {
        return Array.newInstance(type.getComponentType(), 0);
    }

    private Object getPrimitiveInstance(Class type) {
        if (type == int.class) return new Integer(34177239);
        if (type == long.class) return new Long(44762654617L);
        if (type == float.class) return new Float(31.123475);
//        if (type == boolean.class) return randomBoolean();
        throw new UnsupportedOperationException("Please honey pie write the code for primitive type " + type);
    }

    // FIX SC050.  Reinstate when FIXMEs are complete.
//    private Boolean randomBoolean() {
//        // FIX SC050 This ties in with the target approach to triangulation.  Talk to group.
//        // FIX SC043 R Use random.  Not TIME.
//        boolean result = (System.currentTimeMillis() % 2) == 0;
//        return Boolean.valueOf(result);
//    }

    private Object getDataInstance(Class type, TriangulationProvider additional) {
        Constructor constructor = reflectMaster.getConstructor(type);
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] params = getInstances(parameterTypes, additional);
        // FIX SC050 This barfs if the constructor is not "public".  Should be able to lower scope.
        return edgeConstructor.newInstance(constructor, params);
    }
}
