package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.nursery.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.nursery.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.onion.Onion;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;

// FIX 1665 This is an instantiator (not a creator)?

// DEBT LineLength|ClassDataAbstractionCoupling {
public final class DefaultGenericCreator implements GenericCreator {
    // FIX 1665 We should be given the proxy injector, not building it here?
    // FIX 1665 Moved the stinky onion to stop duplication problems.  Fix me now!
    // FIX 1665 Inject these dependencies.
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final Onion onion = new BermudaOnion();
    private final ProxySupplier proxySupplier = new DefaultProxySupplier();
    private final ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);
    private final InvocationHandler invocationHandler = new CreatorInvocationHandler(this);
    private final CreatorProxySupplier creatorProxySupplier = new DefaultCreatorProxySupplier(proxyFactory, invocationHandler);
    private final CreatorFieldFinder creatorFieldFinder = new DefaultCreatorFieldFinder();
    private final CreatorProxyInjector creatorProxyInjector = new DefaultCreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);

    public Object create(Class type, Object[] parameters) {
        Object ref = instantiator.instantiate(type, parameters);
        creatorProxyInjector.inject(ref);
        return onion.onionize(ref);
    }
}
// } DEBT LineLength|ClassDataAbstractionCoupling
