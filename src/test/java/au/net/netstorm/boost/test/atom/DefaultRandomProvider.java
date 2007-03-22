package au.net.netstorm.boost.test.atom;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1676 Move into "random" package?
public final class DefaultRandomProvider implements RandomProvider {
    private static final InvocationHandler NO_OP_INVOCATION_HANDLER = new NoOpInvocationHandler();
    private ProxySupplier proxySupplier = new DefaultProxySupplier();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private RandomProvider concretes = new DefaultRandomConcreteProvider();
    private RandomProvider arrays = new DefaultArrayRandomProvider(this);

    // OK CyclomaticComplexity {
    public Object get(Class type) {
        if (isInterface(type)) return randomInterface(type);
        if (isPrimitive(type)) return randomPrimitiveType(type);
        if (isArray(type)) return randomArray(type);
        return randomSupportedConcrete(type);
    }
    // } OK CyclomaticComplexity

    // FIX 1676 Add isRandomizable method().

    private boolean isInterface(Class type) {
        return type.isInterface();
    }

    private boolean isPrimitive(Class type) {
        return primitiveBoxer.isPrimitive(type);
    }

    private boolean isArray(Class type) {
        return type.isArray();
    }

    private Object randomInterface(Class type) {
        Interface iface = new DefaultInterface(type);
        return proxyFactory.newProxy(iface, NO_OP_INVOCATION_HANDLER);
    }

    private Object randomPrimitiveType(Class type) {
        Class boxed = primitiveBoxer.getBoxed(type);
        return concretes.get(boxed);
    }

    private Object randomSupportedConcrete(Class type) {
        return concretes.get(type);
    }

    private Object randomArray(Class type) {
        return arrays.get(type);
    }
}
