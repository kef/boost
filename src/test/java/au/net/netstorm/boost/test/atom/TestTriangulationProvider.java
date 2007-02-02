package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxySupplier;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class TestTriangulationProvider implements TriangulationProvider {
    private static final InvocationHandler NO_OP_INVOCATION_HANDLER = new NoOpInvocationHandler();
    private static final int ARRAY_LENGTH = 5;
    private EdgeProxySupplier edgeProxySupplier = new DefaultEdgeProxySupplier();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(edgeProxySupplier);
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private RandomProvider randomProvider = new DefaultRandomProvider();

    public Object getInstance(Class type) {
        if (type.isInterface()) {
            return randomInterface(type);
        }
        if (type.isArray()) {
            return randomArray(type);
        }
        if (isPrimitive(type)) {
            return randomPrimitiveType(type);
        }
        return randomJavaType(type);
    }

    public Object[] getInstances(Class[] types) {
        Object[] params = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            params[i] = getInstance(types[i]);
        }
        return params;
    }

    private Object randomPrimitiveType(Class type) {
        Class boxed = primitiveBoxer.getBoxed(type);
        return randomJavaType(boxed);
    }

    private Object randomInterface(Class type) {
        Interface iface = new DefaultInterface(type);
        return proxyFactory.newProxy(iface, NO_OP_INVOCATION_HANDLER);
    }

    private Object randomArray(Class type) {
        Class componentType = type.getComponentType();
        Object array = Array.newInstance(componentType, ARRAY_LENGTH);
        populate(array, componentType);
        return array;
    }

    private boolean isPrimitive(Class type) {
        return primitiveBoxer.isPrimitive(type);
    }

    private Object randomJavaType(Class type) {
        return randomProvider.getRandom(type);
    }

    private void populate(Object array, Class type) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            Object instance = getInstance(type);
            Array.set(array, i, instance);
        }
    }
}
