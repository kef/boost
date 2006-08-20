package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.util.type.DefaultInterface;
import junit.framework.TestCase;

import java.lang.reflect.InvocationHandler;
import java.util.Map;

public final class DefaultProxyFactoryAtomicTest extends TestCase {
    private static final DefaultInterface TYPE_1 = new DefaultInterface(CharSequence.class);
    private static final DefaultInterface TYPE_2 = new DefaultInterface(Map.class);
    private final MockEdgeProxy mockEdgeProxyFactory = new MockEdgeProxy();
    private final ProxyFactory factory = new DefaultProxyFactory(mockEdgeProxyFactory);
    private final InvocationHandler handler = new MockInvocationHandler();

    public void testFactory() {
        checkFactory(TYPE_1);
        checkFactory(TYPE_2);
    }

    private void checkFactory(DefaultInterface type) {
        Object expected = new Object();
        mockEdgeProxyFactory.init(expected);
        Object result = factory.newProxy(type, handler);
        assertSame(expected, result);
        checkCall(type);
    }

    private void checkCall(DefaultInterface type) {
        Class cls = factory.getClass();
        ClassLoader classLoader = cls.getClassLoader();
        DefaultInterface[] types = {type};
        mockEdgeProxyFactory.verify(classLoader, types, handler);
    }
}