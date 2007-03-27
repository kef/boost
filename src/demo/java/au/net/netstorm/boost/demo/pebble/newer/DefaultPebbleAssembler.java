package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.demo.pebble.core.DefaultPebblePortal;
import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.core.DefaultPebbleProviderEngine;
import au.net.netstorm.boost.pebble.core.DefaultProvider;
import au.net.netstorm.boost.pebble.core.PebbleInjectorEngine;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.core.DefaultInjector;
import au.net.netstorm.boost.pebble.inject.core.Injector;
import au.net.netstorm.boost.pebble.inject.core.InjectorEngine;
import au.net.netstorm.boost.pebble.inject.newer.core.DefaultNewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxyInjectorEngine;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.field.DefaultNewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultRegistry;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultRegistryMaster;
import au.net.netstorm.boost.pebble.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.Registry;
import au.net.netstorm.boost.pebble.inject.resolver.core.RegistryMaster;
import au.net.netstorm.boost.pebble.inject.resolver.core.ResolverInjectorEngine;
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

    public DefaultPebbleAssembler(Class citizen) {
        this.citizen = citizen;
    }

    public PebblePortal assemble() {
        ProxyFactory proxyFactory = assembleProxyFactory();
        PassThroughInvocationHandler passThrough = new DefaultPassThroughInvocationHandler();
        PebbleProviderEngine passThroughPebbleProvider = (PebbleProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        RegistryMaster registryMaster = new DefaultRegistryMaster();
        Registry registry = new DefaultRegistry(registryMaster);
        Resolver resolver = new DefaultResolver(passThroughPebbleProvider, registryMaster);
        InjectorEngine injectorEngine = assembleInjector(proxyFactory, passThroughPebbleProvider, instantiator, resolver);
        PebbleProviderEngine pebbleProviderEngine = assembleProvider(injectorEngine, instantiator);
        passThrough.setDelegate(pebbleProviderEngine);
        DefaultProvider provider = new DefaultProvider(pebbleProviderEngine);
        Injector injector = new DefaultInjector(injectorEngine);
        return new DefaultPebblePortal(provider, injector, resolver, registry);
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }

    private InjectorEngine assembleInjector(ProxyFactory proxyFactory, PebbleProviderEngine pebbleProviderEngine, Instantiator instantiator, Resolver resolver) {
        InjectorEngine newer = assembleNewerInjector(proxyFactory, pebbleProviderEngine, instantiator);
        InjectorEngine injector = assembleResolverInjector(resolver);
        return new PebbleInjectorEngine(newer, injector);
    }

    private ResolverInjectorEngine assembleResolverInjector(Resolver resolver) {
        ResolverFieldFinder finder = new DefaultResolverFieldFinder();
        FieldResolver fieldResolver = new DefaultFieldResolver(resolver);
        return new ResolverInjectorEngine(finder, fieldResolver);
    }

    private InjectorEngine assembleNewerInjector(ProxyFactory proxyFactory, PebbleProviderEngine provider, Instantiator instantiator) {
        NewerProxySupplier supplier = new DefaultNewerProxySupplier(proxyFactory, provider, instantiator);
        NewerFieldFinder finder = new DefaultNewerFieldFinder();
        return new NewerProxyInjectorEngine(supplier, finder);
    }

    private PebbleProviderEngine assembleProvider(InjectorEngine injector, Instantiator instantiator) {
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
