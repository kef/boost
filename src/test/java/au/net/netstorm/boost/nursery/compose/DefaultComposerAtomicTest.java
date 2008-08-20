package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.gunge.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.BoooostCase;

// SUGGEST What to do for equals, hashCode, toString...
// SUGGEST Move to using MockInvocationHandler.
// SUGGEST Check exceptions are thrown across the boundary.

// SUGGEST getProxy can be replaced with ProxyFactory.
/**
 * The composer currently only supports composition of two classes.
 */
// DEBT ClassDataAbstractionCoupling {
public final class DefaultComposerAtomicTest extends BoooostCase {
    private static final Interface INTERFACE_A_B = new DefaultInterface(TestInterfaceAB.class);
    private static final Interface INTERFACE_A = new DefaultInterface(TestInterfaceA.class);
    private final ProxyFactory proxyFactory = buildFactory();
    private final MockLayer mockHandlerA = new MockLayer();
    private final MockLayer mockHandlerB = new MockLayer();
    private final MockLayerProxyFactory mockProxyFactory = new MockLayerProxyFactory();
    private final Composer composer = new DefaultComposer(mockProxyFactory);

    // SUGGEST Check interface implements 2 subinterfaces only.
    // SUGGEST Rename.
    // SUGGEST Check implementations cannot change under our feet.  Maybe.  Yes we will need to.
    public void testDouble() {
        Object delegateA = createMockProxy(mockHandlerA);
        Object delegateB = createMockProxy(mockHandlerB);
        Object composed = composer.compose(INTERFACE_A_B, delegateA, delegateB);
        // SUGGEST check delegated to proxy factory.
        // SUGGEST check can be assigned.
        // SUGGEST BREADCRUMB.
    }

    private Object createMockProxy(MockLayer layer) {
        layer.init();
//        return proxyFactory.newProxy(INTERFACE_A, layer);
        return null;
    }

    // SUGGEST Dupe.  See DefaultOneToMany.
    private ProxyFactory buildFactory() {
        return new DefaultProxyFactory();
    }
}
// } DEBT ClassDataAbstractionCoupling
