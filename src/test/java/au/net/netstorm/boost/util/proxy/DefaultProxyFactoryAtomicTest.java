package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// FIXME: SC521 Move into proxy package.
// FIXME: SC521 Complete.

public final class DefaultProxyFactoryAtomicTest extends TestCase {
    private MockEdgeProxyFactory mockEdgeProxyFactory = new MockEdgeProxyFactory();
    private final ProxyFactory factory = new DefaultProxyFactory(mockEdgeProxyFactory);
    private static final Interface TYPE_1 = new Interface(CharSequence.class);

    public void testFactory() {
        Object result = new Object();
        mockEdgeProxyFactory.init(result);
        Interface type = TYPE_1;
        InvocationHandler handler = new MockInvocationHandler();
        Object proxy = factory.newProxy(type, handler);
        // FIXME: SC521 Tidy.
        ClassLoader expectedClassLoader = type.getClass()
                .getClassLoader();
        Interface[] expectedTypes = {TYPE_1};
        InvocationHandler expectedHandler = handler;
        mockEdgeProxyFactory.verify(expectedClassLoader, expectedTypes, expectedHandler);
    }
}