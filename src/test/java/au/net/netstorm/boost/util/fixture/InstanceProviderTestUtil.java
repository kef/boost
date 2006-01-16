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

    public Object[] getInstances(Class[] args) {
        Object[] params = new Object[args.length];
        for (int i = 0; i < args.length; i++) params[i] = getInstance(args[i]);
        return params;
    }

    public Object getInstance(Constructor constructor, Object[] parameters) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new RuntimeException("Constructor does not match expected.", e);
        }
    }

    private Object getInstance(Class type) {
        if (type.isArray()) return getArrayInstance(type);
        if (Data.class.isAssignableFrom(type)) return getDataInstance(type);
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

    private Object getDataInstance(Class type) {
        Constructor constructor = reflectMaster.getConstructor(type);
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] params = getInstances(parameterTypes);
        return reflectEdge.newInstance(constructor, params);
    }
}
