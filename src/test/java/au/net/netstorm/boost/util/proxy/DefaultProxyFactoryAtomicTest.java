package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.Map;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultProxyFactoryAtomicTest extends TestCase {
    private static final Interface TYPE_1 = new DefaultInterface(CharSequence.class);
    private static final Interface TYPE_2 = new DefaultInterface(Map.class);
    private final MockEdgeProxy mockEdgeProxyFactory = new MockEdgeProxy();
    private final ProxyFactory factory = new DefaultProxyFactory(mockEdgeProxyFactory);
    private final InvocationHandler handler = new MockInvocationHandler();

    public void testFactory() {
        checkFactory(TYPE_1);
        checkFactory(TYPE_2);
    }

    private void checkFactory(Interface type) {
        Object expected = new Object();
        mockEdgeProxyFactory.init(expected);
        Object result = factory.newProxy(type, handler);
        assertSame(expected, result);
        checkCall(type);
    }

    private void checkCall(Interface type) {
        Class cls = factory.getClass();
        ClassLoader classLoader = cls.getClassLoader();
        Interface[] types = {type};
        mockEdgeProxyFactory.verify(classLoader, types, handler);
    }
}