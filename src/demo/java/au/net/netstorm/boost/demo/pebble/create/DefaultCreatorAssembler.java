package au.net.netstorm.boost.demo.pebble.create;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.create.CreatorProxySupplier;
import au.net.netstorm.boost.pebble.create.DefaultCreatorProxySupplier;
import au.net.netstorm.boost.pebble.create.DefaultObjectProvider;
import au.net.netstorm.boost.pebble.create.ObjectProvider;
import au.net.netstorm.boost.pebble.create.field.CreatorFieldFinder;
import au.net.netstorm.boost.pebble.create.field.DefaultCreatorFieldFinder;
import au.net.netstorm.boost.pebble.create.inject.CreatorProxyInjector;
import au.net.netstorm.boost.pebble.create.inject.DependencyInjector;
import au.net.netstorm.boost.pebble.create.inject.Injector;
import au.net.netstorm.boost.pebble.create.inject.ObjectInjector;
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
    private static final Interface CREATOR_TYPE = new DefaultInterface(ObjectProvider.class);

    public ObjectProvider assembleCreator() {
        ProxyFactory proxyFactory = assembleProxyFactory();
        PassThroughInvocationHandler passThroughHandler = new DefaultPassThroughInvocationHandler();
        ObjectProvider passThroughObjectProvider = (ObjectProvider) proxyFactory.newProxy(CREATOR_TYPE, passThroughHandler);
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        Injector objectInjector = assembleInjector(proxyFactory, passThroughObjectProvider, instantiator);
        ObjectProvider objectProvider = assembleCreator(objectInjector, instantiator);
        passThroughHandler.setDelegate(objectProvider);
        return objectProvider;
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }

    private Injector assembleInjector(ProxyFactory proxyFactory, ObjectProvider passThroughObjectProvider, Instantiator instantiator) {
        CreatorProxySupplier creatorProxySupplier =
                new DefaultCreatorProxySupplier(proxyFactory, passThroughObjectProvider, instantiator);
        CreatorFieldFinder fieldFinder = new DefaultCreatorFieldFinder();
        Injector creatorProxyInjector = new CreatorProxyInjector(creatorProxySupplier, fieldFinder);
        Injector dependencyInjector = new DependencyInjector();
        return new ObjectInjector(creatorProxyInjector, dependencyInjector);
    }

    private ObjectProvider assembleCreator(Injector objectInjector, Instantiator instantiator) {
        Onion onion = new BermudaOnion();
        return new DefaultObjectProvider(onion, objectInjector, instantiator);
    }
}
