package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.reflect.ReflectEdge;
import au.net.netstorm.boost.util.reflect.ReflectMaster;

// FIXME: SC506 Move instances to their respective unit tests (as per POK theory).
// FIXME: SC502 Interface it.
// FIXME: SC502 Rename.
public class InstanceProviderTestUtil {
    private final ReflectMaster reflectMaster = new DefaultReflectMaster();
    private final ReflectEdge reflectEdge = ReflectEdge.INSTANCE;
    private final InstanceProvider knownTypes = new InstanceProviderTestUtilSuppressed();

    // FIXME: SC050 ? Rename occurrences of "additional" to "extra".
    // FIXME: SC050 BREADCRUMB - Incorporate "additional"
    public Object[] getInstances(Class[] types, InstanceProvider additional) {
        Object[] params = new Object[types.length];
        for (int i = 0; i < types.length; i++) params[i] = getInstance(types[i], additional);
        return params;
    }

    public Object getInstance(Constructor constructor, Object[] parameters) {
        try {
            // FIXME: SC050 ? use an edge class.
            constructor.setAccessible(true);
            return constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new RuntimeException("Constructor does not match expected.", e);
            // FIXME: SC050 This is NOT always the case.  If the object throws ANY exception in the constructor, this will be reported.  FIX!!! 
        }
    }

    private Object getInstance(Class type, InstanceProvider additional) {
        if (type.isArray()) return getArrayInstance(type);
        if (Data.class.isAssignableFrom(type)) return getDataInstance(type, additional);
        if (type.isPrimitive()) return getPrimitiveInstance(type);
        // FIXME: SC050 ? How about trying to load a mock via no-arg class lookup.
        return knownTypes.getInstance(type);
    }

    private Object getArrayInstance(Class type) {
        return Array.newInstance(type.getComponentType(), 0);
    }

    private Object getPrimitiveInstance(Class type) {
        if (type == int.class) return new Integer(56);
        if (type == long.class) return new Long(42L);
        throw new UnsupportedOperationException("Please honey pie write the code for primitive type " + type);
    }

    private Object getDataInstance(Class type, InstanceProvider additional) {
        Constructor constructor = reflectMaster.getConstructor(type);
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] params = getInstances(parameterTypes, additional);
        return reflectEdge.newInstance(constructor, params);
    }
}
