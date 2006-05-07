package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.lang.reflect.DefaultEdgeProxyFactory;
import au.net.netstorm.boost.lang.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
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
    private static final Interface INTERFACE_A = new Interface(TestInterfaceA.class);
    private final ProxyFactory proxyFactory = buildFactory();
    private final MockInvocationHandler mockHandlerA = new MockInvocationHandler();
    private final MockInvocationHandler mockHandlerB = new MockInvocationHandler();
    private final MockProxyFactory mockProxyFactory = new MockProxyFactory();
    private final Composer composer = new DefaultComposer(mockProxyFactory);

    // FIXME: SC521 Check interface implements 2 subinterfaces only.
    // FIXME: SC521 Rename.
    // FIXME: SC521 Check implementations cannot change under our feet.  Maybe.  Yes we will need to.
    public void testDouble() {
        Object delegateA = createMockProxy(mockHandlerA);
        Object delegateB = createMockProxy(mockHandlerB);
        Object composed = composer.compose(INTERFACE_A_B, delegateA, delegateB);
        // FIXME: SC521 check delegated to proxy factory.
        // FIXME: SC521 check can be assigned.
        // FIXME: SC521 BREADCRUMB.
    }

    private Object createMockProxy(MockInvocationHandler mockHandler) {
        mockHandler.init();
        return proxyFactory.newProxy(INTERFACE_A, mockHandler);
    }

    // FIXME: SC521 Dupe.  See DefaultOneToMany.
    private ProxyFactory buildFactory() {
        EdgeProxyFactory edge = new DefaultEdgeProxyFactory();
        return new DefaultProxyFactory(edge);
    }
}