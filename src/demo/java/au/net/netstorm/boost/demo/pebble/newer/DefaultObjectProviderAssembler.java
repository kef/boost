package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.core.DefaultNewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.core.DefaultObjectProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.core.ObjectProvider;
import au.net.netstorm.boost.pebble.inject.newer.field.DefaultNewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.newer.inject.DependencyInjector;
import au.net.netstorm.boost.pebble.inject.newer.inject.Injector;
import au.net.netstorm.boost.pebble.inject.newer.inject.NewerProxyInjector;
import au.net.netstorm.boost.pebble.inject.newer.inject.ObjectInjector;
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

public final class DefaultObjectProviderAssembler implements ObjectProviderAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ObjectProvider.class);

    public ObjectProvider assemble() {
        ProxyFactory proxyFactory = assembleProxyFactory();
        PassThroughInvocationHandler passThroughHandler = new DefaultPassThroughInvocationHandler();
        ObjectProvider passThroughObjectProvider = (ObjectProvider) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThroughHandler);
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        Injector objectInjector = assembleInjector(proxyFactory, passThroughObjectProvider, instantiator);
        ObjectProvider objectProvider = assembleProvider(objectInjector, instantiator);
        passThroughHandler.setDelegate(objectProvider);
        return objectProvider;
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }

    private Injector assembleInjector(ProxyFactory proxyFactory, ObjectProvider objectProvider, Instantiator instantiator) {
        NewerProxySupplier newerProxySupplier = new DefaultNewerProxySupplier(proxyFactory, objectProvider, instantiator);
        NewerFieldFinder fieldFinder = new DefaultNewerFieldFinder();
        Injector newerProxyInjector = new NewerProxyInjector(newerProxySupplier, fieldFinder);
        Injector dependencyInjector = new DependencyInjector();
        return new ObjectInjector(newerProxyInjector, dependencyInjector);
    }

    private ObjectProvider assembleProvider(Injector objectInjector, Instantiator instantiator) {
        Onion onion = new BermudaOnion();
        return new DefaultObjectProvider(onion, objectInjector, instantiator);
    }
}
