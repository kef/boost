package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.Map;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// FIXME: SC521 Move into proxy package.
// FIXME: SC521 Complete.

public final class DefaultProxyFactoryAtomicTest extends TestCase {
    private static final Interface TYPE_1 = new Interface(CharSequence.class);
    private static final Interface TYPE_2 = new Interface(Map.class);
    private final MockEdgeProxyFactory mockEdgeProxyFactory = new MockEdgeProxyFactory();
    private final ProxyFactory factory = new DefaultProxyFactory(mockEdgeProxyFactory);
    private final InvocationHandler handler = new MockInvocationHandler();

    // FIXME: SC521 Triangulate on interface.
    public void testFactory() {
        checkFactory(TYPE_1);
        checkFactory(TYPE_2);
    }

    private void checkFactory(Interface type) {
        Object result = new Object();
        mockEdgeProxyFactory.init(result);
        Object proxy = factory.newProxy(type, handler);
        assertSame(result, proxy);
        checkCall(type);
    }

    private void checkCall(Interface type) {
        Class cls = factory.getClass();
        ClassLoader classLoader = cls.getClassLoader();
        Interface[] types = {type};
        mockEdgeProxyFactory.verify(classLoader, types, handler);
    }
}