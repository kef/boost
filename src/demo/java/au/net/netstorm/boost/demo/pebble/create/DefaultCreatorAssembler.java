package au.net.netstorm.boost.demo.pebble.create;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.create.Creator;
import au.net.netstorm.boost.pebble.create.CreatorFieldFinder;
import au.net.netstorm.boost.pebble.create.CreatorProxyInjector;
import au.net.netstorm.boost.pebble.create.CreatorProxySupplier;
import au.net.netstorm.boost.pebble.create.DefaultCreator;
import au.net.netstorm.boost.pebble.create.DefaultCreatorFieldFinder;
import au.net.netstorm.boost.pebble.create.DefaultCreatorProxySupplier;
import au.net.netstorm.boost.pebble.create.DependencyInjector;
import au.net.netstorm.boost.pebble.create.Injector;
import au.net.netstorm.boost.pebble.create.ObjectInjector;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.pebble.onion.DefaultPassThroughInvocationHandler;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.pebble.onion.PassThroughInvocationHandler;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorAssembler implements CreatorAssembler {
    private static final Interface CREATOR_TYPE = new DefaultInterface(Creator.class);

    public Creator assembleCreator() {
        Onion onion = new BermudaOnion();
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        ProxyFactory proxyFactory = new DefaultProxyFactory(proxySupplier);
        PassThroughInvocationHandler passThroughHandler = new DefaultPassThroughInvocationHandler();
        Creator passThroughCreator = (Creator) proxyFactory.newProxy(CREATOR_TYPE, passThroughHandler);
        Injector objectInjector = assembleInjector(proxyFactory, passThroughCreator, instantiator);
        Creator creator = new DefaultCreator(onion, objectInjector, instantiator);
        passThroughHandler.setDelegate(creator);
        return creator;
    }

    private Injector assembleInjector(ProxyFactory proxyFactory, Creator passThroughCreator, Instantiator instantiator) {
        CreatorProxySupplier creatorProxySupplier =
                new DefaultCreatorProxySupplier(proxyFactory, passThroughCreator, instantiator);
        CreatorFieldFinder fieldFinder = new DefaultCreatorFieldFinder();
        Injector creatorProxyInjector = new CreatorProxyInjector(creatorProxySupplier, fieldFinder);
        Injector dependencyInjector = new DependencyInjector();
        return new ObjectInjector(creatorProxyInjector, dependencyInjector);
    }
}
