package au.net.netstorm.boost.compose;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.reflect.ClassTestUtil;
import au.net.netstorm.boost.reflect.DefaultClassTestUtil;
import au.net.netstorm.boost.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.reflect.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// FIXME: SC521 What to do for equals, hashCode, toString...
// FIXME: SC521 Move to using MockInvocationHandler.
// FIXME: SC521 Check exceptions are thrown across the boundary.
// FIXME: SC521 getProxy can be replaced with ProxyFactory.

/**
 * The composer currently only supports composition of two classes.
 */
public final class DefaultComposerAtomicTest extends TestCase {
    private static final Interface INTERFACE_A_B = new Interface(TestInterfaceAB.class);
    private final ClassTestUtil classer = new DefaultClassTestUtil();
    private final ProxyFactory proxyFactory = new EdgeProxyFactory();
    private final MockInvocationHandler mockHandlerA = new MockInvocationHandler();
    private final MockInvocationHandler mockHandlerB = new MockInvocationHandler();
    private final Composer composer = new DefaultComposer();

    // FIXME: SC521 Check interface implements 2 subinterfaces only.
    // FIXME: SC521 Rename.
    // FIXME: SC521 Check implementations cannot change under our feet.  Maybe.  Yes we will need to.
    public void testDouble() {
        Object delegateA = createMockHandler(mockHandlerA);
        Object delegateB = createMockHandler(mockHandlerB);
        Object composed = composer.compose(INTERFACE_A_B, delegateA, delegateB);
        // FIXME: SC521 check proxy.
        // FIXME: SC521 check can be assigned.
        // FIXME: SC521 BREADCRUMB.
    }

    private Object createMockHandler(MockInvocationHandler mockHandler) {
        mockHandler.init();
        return getProxy(TestInterfaceA.class, mockHandler);
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