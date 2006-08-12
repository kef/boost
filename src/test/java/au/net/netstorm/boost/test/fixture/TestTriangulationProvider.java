package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Array;
import java.util.Random;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeProxy;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxy;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

// FIX SC600 Create demo.

public final class TestTriangulationProvider implements TriangulationProvider {
    private static final InvocationHandler EMTPY_HANDLER = null;
    private EdgeProxy edgeProxy = new DefaultEdgeProxy();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(edgeProxy);
    private Random random = new Random();

    public Object getInstance(Class type) {
        Object ref = doGetInstance(type);
        if (ref != null) return ref;
        throw new UnsupportedOperationException("Hmm.  I cannot provide an instance of '" + type + "'.  Might be worth edgifying this type or talking to the boosters");
    }

    public boolean canProvide(Class type) {
        Object ref = doGetInstance(type);
        return ref != null;
    }

    // FIX SC600 Arrays.
    private Object doGetInstance(Class type) {
        if (type.isInterface()) return randomInterface(type);
        if (type.isArray()) return randomArray(type);
        return randomPrimitive(type);
    }

    private Object randomInterface(Class type) {
        Interface iface = new Interface(type);
        return proxyFactory.newProxy(iface, EMTPY_HANDLER);
    }

    private Object randomArray(Class type) {
        return Array.newInstance(type.getComponentType(), 0);
    }

    private Object randomPrimitive(Class type) {
        if (type == String.class) return randomString();
        if (type == Boolean.class) return randomBoolean();
        if (type == Integer.class) return randomInteger();
        if (type == Long.class) return randomLong();
        if (type == Float.class) return randomFloat();
        if (type == Double.class) return randomDouble();
        return null;
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

    private Long randomLong() {
        long l = random.nextLong();
        return Long.valueOf(l);
    }

    private Float randomFloat() {
        float f = random.nextFloat();
        return Float.valueOf(f);
    }

    private Double randomDouble() {
        double d = random.nextDouble();
        return Double.valueOf(d);
    }
}
