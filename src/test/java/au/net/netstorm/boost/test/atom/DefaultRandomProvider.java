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
    // FIX 1676 Make a RandomProvider iface...
    private RandomConcreteProvider randomConcreteProvider = new DefaultRandomConcreteProvider();
    private RandomArrayProvider randomArrayProvider = new DefaultArrayRandomProvider(this);

    // OK CyclomaticComplexity {
    public Object get(Class type) {
        if (isInterface(type)) return randomInterface(type);
        if (isPrimitive(type)) return randomPrimitiveType(type);
        if (isSupportedConcrete(type)) return randomSupportedConcrete(type);
        if (isArray(type)) return randomArray(type);
        throw new IllegalStateException("Unsupported type " + type);
    }
    // } OK CyclomaticComplexity

    // FIX 1676 Add isRandomizable method().

    private boolean isInterface(Class type) {
        return type.isInterface();
    }

    private boolean isPrimitive(Class type) {
        return primitiveBoxer.isPrimitive(type);
    }

    private boolean isSupportedConcrete(Class type) {
        return randomConcreteProvider.canProvide(type);
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
        return randomConcreteProvider.getRandom(boxed);
    }

    private Object randomSupportedConcrete(Class type) {
        return randomConcreteProvider.getRandom(type);
    }

    private Object randomArray(Class type) {
        return randomArrayProvider.get(type);
    }
}
