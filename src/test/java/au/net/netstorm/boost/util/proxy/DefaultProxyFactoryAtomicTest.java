package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// FIXME: SC521 Move into proxy package.
// FIXME: SC521 Complete.

public final class DefaultProxyFactoryAtomicTest extends TestCase {
    private static final Interface TYPE_1 = new Interface(CharSequence.class);
    private final MockEdgeProxyFactory mockEdgeProxyFactory = new MockEdgeProxyFactory();
    private final ProxyFactory factory = new DefaultProxyFactory(mockEdgeProxyFactory);
    private final InvocationHandler handler = new MockInvocationHandler();

    // FIXME: SC521 Triangulate on interface.
    public void testFactory() {
        Object result = new Object();
        mockEdgeProxyFactory.init(result);
        Object proxy = factory.newProxy(TYPE_1, handler);
        assertSame(result, proxy);
        // FIXME: SC521 Check return value.
        Class cls = factory.getClass();
        ClassLoader classLoader = cls.getClassLoader();
        Interface[] types = {TYPE_1};
        mockEdgeProxyFactory.verify(classLoader, types, handler);
    }
}