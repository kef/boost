package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.core.DefaultPebbleProvider;
import au.net.netstorm.boost.pebble.core.PebbleInjector;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.DefaultNewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxyInjector;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.field.DefaultNewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.Resolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.ResolverInjector;
import au.net.netstorm.boost.pebble.inject.resolver.field.DefaultResolverFieldFinder;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
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

public final class DefaultPebbleProviderAssembler implements PebbleProviderAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(PebbleProvider.class);
    private Resolver resolver;

    public DefaultPebbleProviderAssembler(Resolver resolver) {
        this.resolver = resolver;
    }

    public PebbleProvider assemble() {
        ProxyFactory proxyFactory = assembleProxyFactory();
        PassThroughInvocationHandler passThroughHandler = new DefaultPassThroughInvocationHandler();
        PebbleProvider passThroughPebbleProvider = (PebbleProvider) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThroughHandler);
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        Injector objectInjector = assembleInjector(proxyFactory, passThroughPebbleProvider, instantiator);
        PebbleProvider pebbleProvider = assembleProvider(objectInjector, instantiator);
        passThroughHandler.setDelegate(pebbleProvider);
        return pebbleProvider;
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }

    private Injector assembleInjector(ProxyFactory proxyFactory, PebbleProvider pebbleProvider, Instantiator instantiator) {
        Injector newerProxyInjector = assembleNewerInjector(proxyFactory, pebbleProvider, instantiator);
        Injector resolverInjector = assembleResolverInjector(pebbleProvider);
        // FIX 1715 Put some stitches in this...
        return new PebbleInjector(newerProxyInjector, resolverInjector); // FIX 1715 Cheat until we stitch in resolver injector.
    }

    private ResolverInjector assembleResolverInjector(PebbleProvider pebbleProvider) {
        ResolverFieldFinder fieldFinder = new DefaultResolverFieldFinder();
        FieldResolver fieldResolver = new DefaultFieldResolver(resolver, pebbleProvider);
        return new ResolverInjector(fieldFinder, fieldResolver);
    }

    private Injector assembleNewerInjector(ProxyFactory proxyFactory, PebbleProvider pebbleProvider, Instantiator instantiator) {
        NewerProxySupplier newerProxySupplier = new DefaultNewerProxySupplier(proxyFactory, pebbleProvider, instantiator);
        NewerFieldFinder newerFieldFinder = new DefaultNewerFieldFinder();
        return new NewerProxyInjector(newerProxySupplier, newerFieldFinder);
    }

    private PebbleProvider assembleProvider(Injector objectInjector, Instantiator instantiator) {
        Onion onion = new BermudaOnion();
        return new DefaultPebbleProvider(onion, objectInjector, instantiator);
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
