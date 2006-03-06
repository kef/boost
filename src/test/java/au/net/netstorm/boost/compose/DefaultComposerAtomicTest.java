package au.net.netstorm.boost.compose;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.reflect.ProxyFactory;
import junit.framework.TestCase;

// FIXME: SC521 What to do for equals, hashCode, toString...
// FIXME: SC521 Move to using MockInvocationHandler.
// FIXME: SC521 Check exceptions are thrown across the boundary.
// FIXME: SC521 getProxy can be replaced with ProxyFactory.

public final class DefaultComposerAtomicTest extends TestCase {
    private final ProxyFactory proxyFactory = new EdgeProxyFactory();
    private final MockInvocationHandler mockHandlerA = new MockInvocationHandler();
    private final Composer composer = new DefaultComposer();

    public void testUnsupported() {
        // FIXME: SC521 Test failure modes for 0,1, 3 or more composed.
    }

    // FIXME: SC521 Rename.
    // FIXME: SC521 Check implementations cannot change under our feet.  Maybe.  Yes we will need to.
    public void testDouble() {
        mockHandlerA.init();
        Object ref = getProxy(TestInterfaceA.class, mockHandlerA);
    }

    private Object getProxy(Class iface, InvocationHandler handler) {
        Class cls = getClass();
        ClassLoader loader = cls.getClassLoader();
        Class[] types = {iface};
        return proxyFactory.getProxy(loader, types, handler);
    }

    // FIXME: SC521 Complete.
//    public void testDouble();
}