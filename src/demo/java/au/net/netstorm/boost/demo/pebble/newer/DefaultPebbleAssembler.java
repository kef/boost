package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.demo.pebble.core.DefaultPebblePortal;
import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.core.DefaultPebbleProvider;
import au.net.netstorm.boost.pebble.core.DefaultPebbleProviderEngine;
import au.net.netstorm.boost.pebble.core.PebbleInjector;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.newer.core.DefaultNewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxyInjector;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.field.DefaultNewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.RegistryEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.ResolverInjector;
import au.net.netstorm.boost.pebble.inject.resolver.field.DefaultResolverFieldFinder;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.pebble.onion.BermudaOnion;
import au.net.netstorm.boost.pebble.onion.DefaultPassThroughInvocationHandler;
import au.net.netstorm.boost.pebble.onion.Onion;
import au.net.netstorm.boost.pebble.onion.PassThroughInvocationHandler;
import au.net.netstorm.boost.pebble.resolve.DefaultResolver;
import au.net.netstorm.boost.pebble.resolve.Resolver;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultPebbleAssembler implements PebbleAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(PebbleProviderEngine.class);
    private final Class citizen;
    private final RegistryEngine registryEngine;

    public DefaultPebbleAssembler(Class citizen, RegistryEngine registryEngine) {
        this.registryEngine = registryEngine;
        this.citizen = citizen;
    }

    public PebblePortal assemble() {
        ProxyFactory proxyFactory = assembleProxyFactory();
        PassThroughInvocationHandler passThrough = new DefaultPassThroughInvocationHandler();
        PebbleProviderEngine passThroughPebbleProvider = (PebbleProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        Resolver resolver = new DefaultResolver(passThroughPebbleProvider, registryEngine);
        Injector objectInjector = assembleInjector(proxyFactory, passThroughPebbleProvider, instantiator, resolver);
        PebbleProviderEngine pebbleProviderEngine = assembleProvider(objectInjector, instantiator);
        passThrough.setDelegate(pebbleProviderEngine);
        DefaultPebbleProvider pebbleProvider = new DefaultPebbleProvider(pebbleProviderEngine);
        return new DefaultPebblePortal(pebbleProvider, objectInjector, resolver);
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }

    private Injector assembleInjector(ProxyFactory proxyFactory, PebbleProviderEngine pebbleProviderEngine, Instantiator instantiator, Resolver resolver) {
        Injector newer = assembleNewerInjector(proxyFactory, pebbleProviderEngine, instantiator);
        Injector injector = assembleResolverInjector(resolver);
        return new PebbleInjector(newer, injector);
    }

    private ResolverInjector assembleResolverInjector(Resolver resolver) {
        ResolverFieldFinder finder = new DefaultResolverFieldFinder();
        FieldResolver fieldResolver = new DefaultFieldResolver(resolver);
        return new ResolverInjector(finder, fieldResolver);
    }

    private Injector assembleNewerInjector(ProxyFactory proxyFactory, PebbleProviderEngine provider, Instantiator instantiator) {
        NewerProxySupplier supplier = new DefaultNewerProxySupplier(proxyFactory, provider, instantiator);
        NewerFieldFinder finder = new DefaultNewerFieldFinder();
        return new NewerProxyInjector(supplier, finder);
    }

    private PebbleProviderEngine assembleProvider(Injector injector, Instantiator instantiator) {
        Onion onion = new BermudaOnion();
        Interface marker = new DefaultInterface(citizen);
        return new DefaultPebbleProviderEngine(marker, onion, injector, instantiator);
    }
    /*
      , ; ,   .-'"""'-.   , ; ,
      \\|/  .'         '.  \|//
       \-;-/   ()   ()   \-;-/
       // ;               ; \\
      //__; :.         .; ;__\\
     `-----\'.'-.....-'.'/-----'
            '.'.-.-,_.'.'
              '(  (..-'
                '-'
    */
}
