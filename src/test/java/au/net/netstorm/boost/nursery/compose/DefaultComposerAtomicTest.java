package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeProxy;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxy;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// FIX SC521 What to do for equals, hashCode, toString...
// FIX SC521 Move to using MockInvocationHandler.
// FIX SC521 Check exceptions are thrown across the boundary.
// FIX SC521 getProxy can be replaced with ProxyFactory.
/**
 * The composer currently only supports composition of two classes.
 */
public final class DefaultComposerAtomicTest extends TestCase {
    private static final Interface INTERFACE_A_B = new DefaultInterface(TestInterfaceAB.class);
    private static final Interface INTERFACE_A = new DefaultInterface(TestInterfaceA.class);
    private final ProxyFactory proxyFactory = buildFactory();
    private final MockInvocationHandler mockHandlerA = new MockInvocationHandler();
    private final MockInvocationHandler mockHandlerB = new MockInvocationHandler();
    private final MockProxyFactory mockProxyFactory = new MockProxyFactory();
    private final Composer composer = new DefaultComposer(mockProxyFactory);

    // FIX SC521 Check interface implements 2 subinterfaces only.
    // FIX SC521 Rename.
    // FIX SC521 Check implementations cannot change under our feet.  Maybe.  Yes we will need to.
    public void testDouble() {
        Object delegateA = createMockProxy(mockHandlerA);
        Object delegateB = createMockProxy(mockHandlerB);
        Object composed = composer.compose(INTERFACE_A_B, delegateA, delegateB);
        // FIX SC521 check delegated to proxy factory.
        // FIX SC521 check can be assigned.
        // FIX SC521 BREADCRUMB.
    }

    private Object createMockProxy(MockInvocationHandler mockHandler) {
        mockHandler.init();
        return proxyFactory.newProxy(INTERFACE_A, mockHandler);
    }

    // FIX SC521 Dupe.  See DefaultOneToMany.
    private ProxyFactory buildFactory() {
        EdgeProxy edge = new DefaultEdgeProxy();
        return new DefaultProxyFactory(edge);
    }
}