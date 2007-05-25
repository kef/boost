package au.net.netstorm.boost.demo.spider.core;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.core.CitizenInjectorEngine;
import au.net.netstorm.boost.spider.core.DefaultProvider;
import au.net.netstorm.boost.spider.core.DefaultProviderEngine;
import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.core.SpiderTryFinally;
import au.net.netstorm.boost.spider.inject.core.DefaultInjector;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.newer.assembly.DefaultNewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.spider.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.spider.inject.resolver.core.ResolverInjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolverFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.spider.onion.core.BermudaOnionizer;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.spider.onion.layer.closure.DefaultTryFinallyHandler;
import au.net.netstorm.boost.spider.onion.layer.closure.TryFinally;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.spider.resolve.DefaultRegistry;
import au.net.netstorm.boost.spider.resolve.DefaultRegistryMaster;
import au.net.netstorm.boost.spider.resolve.DefaultResolver;
import au.net.netstorm.boost.spider.resolve.DefaultResolverEngine;
import au.net.netstorm.boost.spider.resolve.FinderEngine;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.spider.resolve.RegistryEngine;
import au.net.netstorm.boost.spider.resolve.RegistryMaster;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultSpiderAssembler implements SpiderAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ProviderEngine.class);
    private static final Interface SPIDER_TYPE = new DefaultInterface(Spider.class);
    private static final ResolvedThings RESOLVED_THINGS = new DefaultResolvedThings();
    private final PassThroughLayer passThrough = new DefaultPassThroughLayer();
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final ProxyFactory proxyFactory = assembleProxyFactory();
    private final Interface citizen;

    public DefaultSpiderAssembler(Class citizen) {
        this.citizen = new DefaultInterface(citizen);
    }

    public Spider assemble() {
        ProviderEngine passThroughProvider = (ProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        RegistryMaster registryMaster = brandNewRegistry();
        ResolverEngine resolverEngine = assembleResolver(passThroughProvider, registryMaster);
        InjectorEngine injectorEngine = assembleInjector(resolverEngine);
        ProviderEngine providerEngine = assembleProvider(injectorEngine, instantiator);
        passThrough.setDelegate(providerEngine);
        Spider spider = buildSpider(providerEngine, resolverEngine, injectorEngine, registryMaster);
        return threadLocal(spider);
    }

    private Spider threadLocal(Spider spider) {
        TryFinally tryFinally = new SpiderTryFinally(RESOLVED_THINGS);
        InvocationHandler handler = new DefaultTryFinallyHandler(spider, tryFinally);
        return (Spider) proxyFactory.newProxy(SPIDER_TYPE, handler);
    }

    private Spider buildSpider(ProviderEngine providerEngine,
            ResolverEngine resolverEngine,
            InjectorEngine injectorEngine,
            RegistryEngine spinnerEngine) {
        Provider provider = new DefaultProvider(providerEngine);
        Resolver resolver = new DefaultResolver(resolverEngine);
        Injector injector = new DefaultInjector(injectorEngine);
        Registry registry = new DefaultRegistry(spinnerEngine);
        return new DefaultSpider(provider, injector, resolver, registry);
    }

    private RegistryMaster brandNewRegistry() {
        return new DefaultRegistryMaster();
    }

    private DefaultResolverEngine assembleResolver(ProviderEngine passThroughProvider, FinderEngine finder) {
        NewerAssembler newerAssembler = new DefaultNewerAssembler(passThroughProvider);
        return new DefaultResolverEngine(passThroughProvider, finder, newerAssembler);
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }

    private InjectorEngine assembleInjector(ResolverEngine resolver) {
        InjectorEngine injector = assembleResolverInjector(resolver);
        return new CitizenInjectorEngine(injector);
    }

    private ResolverInjectorEngine assembleResolverInjector(ResolverEngine resolver) {
        ResolverFieldFinder finder = new DefaultResolverFieldFinder();
        FieldResolver fieldResolver = new DefaultFieldResolver(resolver);
        return new ResolverInjectorEngine(finder, fieldResolver);
    }

    private ProviderEngine assembleProvider(InjectorEngine injector, Instantiator instantiator) {
        Onionizer onionizer = new BermudaOnionizer();
        return new DefaultProviderEngine(citizen, onionizer, injector, instantiator);
    }
    /*
                  _.._
                .SPIDER.
               /   []   \
            ,  \   <>   |  ,
           . \  \      /  / .
            \_'--`(  )'--'_/
              .--'/()\'--.
             /  /` '' `\  \
               |        |
                \      /

    */
}
