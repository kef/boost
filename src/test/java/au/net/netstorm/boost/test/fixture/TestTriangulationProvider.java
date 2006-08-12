package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.InvocationHandler;
import java.util.Random;

import au.net.netstorm.boost.util.exception.NotImplementedException;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxy;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeProxy;

// FIXME: SC600 Create demo.
public final class TestTriangulationProvider implements TriangulationProvider {
    private static final InvocationHandler EMTPY_HANDLER = null;
    private EdgeProxy edgeProxy = new DefaultEdgeProxy();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(edgeProxy);
    private Random random = new Random();

    public Object getInstance(Class type) {
        Object ref = doGetInstance(type);
        if (ref != null) return ref;
        throw new UnsupportedOperationException("Hmm.  Provide an instance of " + type + ".  Might be worth edgifying this type or talking to the boosters");
    }

    public boolean canProvide(Class type) {
        Object ref = doGetInstance(type);
        return ref != null;
    }

    private Object doGetInstance(Class type) {
        if (type.isInterface()) return randomInterface(type);
        if (type == String.class) return randomString();
        if (type == Boolean.class) return randomBoolean();
        if (type == Integer.class) return randomInteger();
        // FIXME: SC600 return Primitive types.
        throw new NotImplementedException();
    }

    private Object randomInterface(Class type) {
        Interface iface = new Interface(type);
        return proxyFactory.newProxy(iface, EMTPY_HANDLER);
    }

    private String randomString() {
        return "" + random.nextLong();
    }

    private Boolean randomBoolean() {
        boolean bool = random.nextBoolean();
        return Boolean.valueOf(bool);
    }

    private Integer randomInteger() {
        int i = random.nextInt();
        return Integer.valueOf(i);
    }
}
