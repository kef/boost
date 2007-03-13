package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.pebble.newer.core.DefaultNewerProxySupplier;
import au.net.netstorm.boost.pebble.newer.core.DefaultObjectProvider;
import au.net.netstorm.boost.pebble.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.pebble.newer.core.ObjectProvider;
import au.net.netstorm.boost.pebble.newer.field.DefaultNewerFieldFinder;
import au.net.netstorm.boost.pebble.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.pebble.newer.inject.DependencyInjector;
import au.net.netstorm.boost.pebble.newer.inject.Injector;
import au.net.netstorm.boost.pebble.newer.inject.NewerProxyInjector;
import au.net.netstorm.boost.pebble.newer.inject.ObjectInjector;
import au.net.netstorm.boost.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.pebble.onion.DefaultPassThroughInvocationHandler;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.pebble.onion.PassThroughInvocationHandler;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerAssembler implements NewerAssembler {
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
        NewerProxySupplier newerProxySupplier =
                new DefaultNewerProxySupplier(proxyFactory, passThroughObjectProvider, instantiator);
        NewerFieldFinder fieldFinder = new DefaultNewerFieldFinder();
        Injector creatorProxyInjector = new NewerProxyInjector(newerProxySupplier, fieldFinder);
        Injector dependencyInjector = new DependencyInjector();
        return new ObjectInjector(creatorProxyInjector, dependencyInjector);
    }

    private ObjectProvider assembleCreator(Injector objectInjector, Instantiator instantiator) {
        Onion onion = new BermudaOnion();
        return new DefaultObjectProvider(onion, objectInjector, instantiator);
    }
}
