package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// FIXME: SC521 Move into proxy package.
// FIXME: SC521 Complete.

public final class DefaultProxyFactoryAtomicTest extends TestCase {
    private final ProxyFactory factory = new DefaultProxyFactory();

    public void testFactory() {
        Interface type = new Interface(CharSequence.class);
        InvocationHandler handler = new MockInvocationHandler();
        Object proxy = factory.newProxy(type, handler);
    }
}