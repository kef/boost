package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.demo.spider.core.DefaultSpider;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.core.CitizenInjectorEngine;
import au.net.netstorm.boost.spider.core.DefaultProvider;
import au.net.netstorm.boost.spider.core.DefaultProviderEngine;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.inject.core.DefaultInjector;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.newer.core.DefaultNewerProxySupplier;
import au.net.netstorm.boost.spider.inject.newer.core.NewerProxyInjectorEngine;
import au.net.netstorm.boost.spider.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.spider.inject.newer.field.DefaultNewerFieldFinder;
import au.net.netstorm.boost.spider.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.spider.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.spider.inject.resolver.core.ResolverInjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolverFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.spider.onion.BermudaOnionizer;
import au.net.netstorm.boost.spider.onion.DefaultPassThroughInvocationHandler;
import au.net.netstorm.boost.spider.onion.Onionizer;
import au.net.netstorm.boost.spider.onion.PassThroughInvocationHandler;
import au.net.netstorm.boost.spider.resolve.DefaultRegistry;
import au.net.netstorm.boost.spider.resolve.DefaultRegistryMaster;
import au.net.netstorm.boost.spider.resolve.DefaultResolverEngine;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.spider.resolve.RegistryMaster;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultSpiderAssembler implements SpiderAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ProviderEngine.class);
    private final Class citizen;

    public DefaultSpiderAssembler(Class citizen) {
        this.citizen = citizen;
    }

    public Spider assemble() {
        ProxyFactory proxyFactory = assembleProxyFactory();
        PassThroughInvocationHandler passThrough = new DefaultPassThroughInvocationHandler();
        ProviderEngine passThroughProvider = (ProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        RegistryMaster registryMaster = new DefaultRegistryMaster();
        Registry registry = new DefaultRegistry(registryMaster);
        ResolverEngine resolver = new DefaultResolverEngine(passThroughProvider, registryMaster);
        InjectorEngine injectorEngine = assembleInjector(proxyFactory, passThroughProvider, instantiator, resolver);
        ProviderEngine providerEngine = assembleProvider(injectorEngine, instantiator);
        passThrough.setDelegate(providerEngine);
        DefaultProvider provider = new DefaultProvider(providerEngine);
        Injector injector = new DefaultInjector(injectorEngine);
        return new DefaultSpider(provider, injector, resolver, registry);
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }

    private InjectorEngine assembleInjector(ProxyFactory proxyFactory, ProviderEngine providerEngine, Instantiator instantiator, ResolverEngine resolver) {
        InjectorEngine newer = assembleNewerInjector(proxyFactory, providerEngine, instantiator);
        InjectorEngine injector = assembleResolverInjector(resolver);
        return new CitizenInjectorEngine(newer, injector);
    }

    private ResolverInjectorEngine assembleResolverInjector(ResolverEngine resolver) {
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
                  _.._
                .'    '.
               /   __   \
            ,  |   ><   |  ,
           . \  \      /  / .
            \_'--`(  )'--'_/
              .--'/()\'--.
             /  /` '' `\  \
               |        |
                \      /

    */
}
