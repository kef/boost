package au.net.netstorm.boost.util.fixture;



import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.reflect.ReflectEdge;
import au.net.netstorm.boost.util.reflect.ReflectMaster;

// FIXME: SC501 Move instances to their respective unit tests (as per POK theory).
public class InstanceProviderTestUtil {
    private static final ReflectMaster REFLECT_MASTER = new DefaultReflectMaster();
    private static final ReflectEdge REFLECT_EDGE = ReflectEdge.INSTANCE;

    public static Object getInstance(Class type) {
        if (type.isArray()) return getArrayInstance(type);
        if (Data.class.isAssignableFrom(type)) return getDataInstance(type);
        if (type.isPrimitive()) return getPrimitiveInstance(type);
        return InstanceProviderTestUtilSuppressed.getSimpleInstance(type);
    }

    public static Object getInstance(Constructor constructor, Object[] parameters) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new RuntimeException("Constructor does not match expected.", e);
        }
    }

    public static Object[] getInstances(Class[] args) {
        Object[] params = new Object[args.length];
        for (int i = 0; i < args.length; i++) params[i] = getInstance(args[i]);
        return params;
    }

    private static Object getArrayInstance(Class type) {
        return Array.newInstance(type.getComponentType(), 0);
    }

    private static Object getPrimitiveInstance(Class type) {
        if (type == int.class) return new Integer(56);
        if (type == long.class) return new Long(42L);
        throw new UnsupportedOperationException("Please honey pie write the code for primitive type " + type);
    }

    private static Object getDataInstance(Class type) {
        Constructor constructor = REFLECT_MASTER.getConstructor(type);
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] params = getInstances(parameterTypes);
        return REFLECT_EDGE.newInstance(constructor, params);
    }
}
