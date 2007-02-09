package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;

// DEBT LineLength|ClassDataAbstractionCoupling {
public final class DefaultCreator implements Creator {
    // FIX 1665 Move assembly out into demo area.
    // FIX 1665 Introduce the proxy pass through.
    // FIX 1665 Pass in "true" depencencies.
    // FIX 1665 Move the wiring into CreatorWirer.
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final Onion onion = new BermudaOnion();
    private final ProxySupplier proxySupplier = new DefaultProxySupplier();
    private final ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);
    //    private final PassThroughInvocationHandler passThroughInvocationHandler = new DefaultPassThroughInvocationHandler();
    private final CreatorProxySupplier creatorProxySupplier =
            new DefaultCreatorProxySupplier(proxyFactory, this, instantiator);
    private final CreatorFieldFinder creatorFieldFinder = new DefaultCreatorFieldFinder();
    private final CreatorProxyInjector creatorProxyInjector =
            new DefaultCreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);

    public Object create(Class type, Object[] parameters) {
        Object ref = instantiator.instantiate(type, parameters);
        creatorProxyInjector.inject(ref);
        return onion.onionize(ref);
    }
}
// } DEBT LineLength|ClassDataAbstractionCoupling
