package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.Map;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultProxyFactoryAtomicTest extends BoooostCase {
    private static final Interface TYPE_1 = new DefaultInterface(CharSequence.class);
    private static final Interface TYPE_2 = new DefaultInterface(Map.class);
    private static final Interface[] TYPES = {TYPE_1, TYPE_2};
    private final MockProxySupplier mockEdgeProxyFactory = new MockProxySupplier();
    private final ProxyFactory factory = new DefaultProxyFactory(mockEdgeProxyFactory);
    private final InvocationHandler handler = new MockInvocationHandler();

    public void testSingleType() {
        checkSingleType(TYPE_1);
        checkSingleType(TYPE_2);
    }

    public void testMultipleTypes() {
        checkMultipleTypes(TYPES);
    }

    private void checkSingleType(Interface type) {
        Object expected = prepare();
        Object result = factory.newProxy(type, handler);
        assertSame(expected, result);
        checkCall(type);
    }

    private void checkMultipleTypes(Interface[] types) {
        Object expected = prepare();
        Object result = factory.newProxy(types, handler);
        assertSame(expected, result);
        checkCall(types);
    }

    private Object prepare() {
        Object expected = new Object();
        mockEdgeProxyFactory.init(expected);
        return expected;
    }

    private void checkCall(Interface type) {
        Interface[] types = {type};
        checkCall(types);
    }

    private void checkCall(Interface[] types) {
        Class cls = factory.getClass();
        ClassLoader classLoader = cls.getClassLoader();
        mockEdgeProxyFactory.verify(classLoader, types, handler);
    }
}