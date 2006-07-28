package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeReflect;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.Data;

// FIXME: SC502 Move instances to their respective unit tests (as per POK theory).
// FIXME: SC502 Interface it.
// FIXME: SC502 Rename.

public final class InstanceProviderTestUtil {
    private final ReflectMaster reflectMaster = new DefaultReflectMaster();
    private final EdgeReflect reflectEdge = EdgeReflect.EDGE_REFLECT;
    private final InstanceProviderForTest knownTypes = new InstanceProviderTestUtilSuppressed();

    // FIXME: SC050 ? Rename occurrences of "additional" to "extra".
    // FIXME: SC050 BREADCRUMB - Incorporate "additional"
    public Object[] getInstances(Class[] types, InstanceProviderForTest additional) {
        Object[] params = new Object[types.length];
        for (int i = 0; i < types.length; i++) params[i] = getInstance(types[i], additional);
        return params;
    }

    public Object getInstance(Constructor constructor, Object[] parameters) {
        try {
            // FIXME: SC523 Edge class exists now, use it. Is the exception message below meaningful?
            // FIXME: SC050 ? use an edge class.
            constructor.setAccessible(true);
            return constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new RuntimeException("Constructor does not match expected.", e);
            // FIXME: SC050 This is NOT always the case.  If the object throws ANY exception in the constructor, this will be reported.  FIX!!!
            // FIXME: SC050 Ensure ALL Mock* are serializable.  Required if they are to be used in testing DATA objects which in turn may need to be serializable.
        }
    }

    private Object getInstance(Class type, InstanceProviderForTest additional) {
        if (type.isArray()) return getArrayInstance(type);
        if (Data.class.isAssignableFrom(type)) return getDataInstance(type, additional);
        if (type.isPrimitive()) return getPrimitiveInstance(type);
        // FIXME: SC050 We have to be careful object are primitive, data, immutable.  Where is this check?
        // FIXME: SC050 ? How about trying to load a mock via no-arg class lookup.
        return knownTypes.getInstance(type);
    }

    private Object getArrayInstance(Class type) {
        return Array.newInstance(type.getComponentType(), 0);
    }

    private Object getPrimitiveInstance(Class type) {
        if (type == int.class) return new Integer(34177239);
        if (type == long.class) return new Long(44762654617L);
        if (type == float.class) return new Float(31.123475);
        if (type == boolean.class) return randomBoolean();
        throw new UnsupportedOperationException("Please honey pie write the code for primitive type " + type);
    }

    private Boolean randomBoolean() {
        // FIXME: SC050 This ties in with the target approach to triangulation.  Talk to group.
        boolean result = (System.currentTimeMillis() % 2) == 0;
        return Boolean.valueOf(result);
    }

    private Object getDataInstance(Class type, InstanceProviderForTest additional) {
        Constructor constructor = reflectMaster.getConstructor(type);
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] params = getInstances(parameterTypes, additional);
        return reflectEdge.newInstance(constructor, params);
    }
}
