package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.demo.pebble.core.DefaultPebble;
import au.net.netstorm.boost.demo.pebble.core.Pebble;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.pebble.core.DefaultProvider;
import au.net.netstorm.boost.pebble.core.DefaultProviderEngine;
import au.net.netstorm.boost.pebble.core.PebbleInjectorEngine;
import au.net.netstorm.boost.pebble.core.ProviderEngine;
import au.net.netstorm.boost.pebble.inject.core.DefaultInjector;
import au.net.netstorm.boost.pebble.inject.core.Injector;
import au.net.netstorm.boost.pebble.inject.core.InjectorEngine;
import au.net.netstorm.boost.pebble.inject.newer.core.DefaultNewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxyInjectorEngine;
import au.net.netstorm.boost.pebble.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.pebble.inject.newer.field.DefaultNewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.pebble.inject.resolver.core.ResolverInjectorEngine;
import au.net.netstorm.boost.pebble.inject.resolver.field.DefaultResolverFieldFinder;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.pebble.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.pebble.onion.BermudaOnionizer;
import au.net.netstorm.boost.pebble.onion.DefaultPassThroughInvocationHandler;
import au.net.netstorm.boost.pebble.onion.Onionizer;
import au.net.netstorm.boost.pebble.onion.PassThroughInvocationHandler;
import au.net.netstorm.boost.pebble.resolve.DefaultRegistry;
import au.net.netstorm.boost.pebble.resolve.DefaultRegistryMaster;
import au.net.netstorm.boost.pebble.resolve.DefaultResolver;
import au.net.netstorm.boost.pebble.resolve.Registry;
import au.net.netstorm.boost.pebble.resolve.RegistryMaster;
import au.net.netstorm.boost.pebble.resolve.Resolver;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultPebbleAssembler implements PebbleAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ProviderEngine.class);
    private final Class citizen;

    public DefaultPebbleAssembler(Class citizen) {
        this.citizen = citizen;
    }

    public Pebble assemble() {
        ProxyFactory proxyFactory = assembleProxyFactory();
        PassThroughInvocationHandler passThrough = new DefaultPassThroughInvocationHandler();
        ProviderEngine passThroughProvider = (ProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        RegistryMaster registryMaster = new DefaultRegistryMaster();
        Registry registry = new DefaultRegistry(registryMaster);
        Resolver resolver = new DefaultResolver(passThroughProvider, registryMaster);
        InjectorEngine injectorEngine = assembleInjector(proxyFactory, passThroughProvider, instantiator, resolver);
        ProviderEngine providerEngine = assembleProvider(injectorEngine, instantiator);
        passThrough.setDelegate(providerEngine);
        DefaultProvider provider = new DefaultProvider(providerEngine);
        Injector injector = new DefaultInjector(injectorEngine);
        return new DefaultPebble(provider, injector, resolver, registry);
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }

    private InjectorEngine assembleInjector(ProxyFactory proxyFactory, ProviderEngine providerEngine, Instantiator instantiator, Resolver resolver) {
        InjectorEngine newer = assembleNewerInjector(proxyFactory, providerEngine, instantiator);
        InjectorEngine injector = assembleResolverInjector(resolver);
        return new PebbleInjectorEngine(newer, injector);
    }

    private ResolverInjectorEngine assembleResolverInjector(Resolver resolver) {
        ResolverFieldFinder finder = new DefaultResolverFieldFinder();
        FieldResolver fieldResolver = new DefaultFieldResolver(resolver);
        return new ResolverInjectorEngine(finder, fieldResolver);
    }

    private InjectorEngine assembleNewerInjector(ProxyFactory proxyFactory, ProviderEngine provider, Instantiator instantiator) {
        NewerProxySupplier supplier = new DefaultNewerProxySupplier(proxyFactory, provider, instantiator);
        NewerFieldFinder finder = new DefaultNewerFieldFinder();
        return new NewerProxyInjectorEngine(supplier, finder);
    }

    private ProviderEngine assembleProvider(InjectorEngine injector, Instantiator instantiator) {
        Onionizer onionizer = new BermudaOnionizer();
        Interface marker = new DefaultInterface(citizen);
        return new DefaultProviderEngine(marker, onionizer, injector, instantiator);
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
