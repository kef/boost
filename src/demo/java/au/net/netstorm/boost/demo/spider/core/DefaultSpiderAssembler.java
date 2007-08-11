package au.net.netstorm.boost.demo.spider.core;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.nursery.spider.onion.core.BermudaOnionizer;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.core.DefaultProvider;
import au.net.netstorm.boost.spider.core.DefaultProviderEngine;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.core.SpiderTryCatchFinally;
import au.net.netstorm.boost.spider.inject.core.DefaultInjector;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.newer.assembly.DefaultNewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.assembly.DefaultProxyFactoryAssembler;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.assembly.ProxyFactoryAssembler;
import au.net.netstorm.boost.spider.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.spider.inject.resolver.core.DefaultInjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.spider.onion.layer.closure.DefaultTryCatchFinallyHandler;
import au.net.netstorm.boost.spider.onion.layer.closure.TryCatchFinally;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.spider.registry.BlueprintMaster;
import au.net.netstorm.boost.spider.registry.InstanceMaster;
import au.net.netstorm.boost.spider.resolve.DefaultResolver;
import au.net.netstorm.boost.spider.resolve.DefaultResolverEngine;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultSpiderAssembler implements SpiderAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ProviderEngine.class);
    private static final Interface SPIDER_TYPE = new DefaultInterface(Spider.class);
    private static final ResolvedThings RESOLVED_THINGS = new DefaultResolvedThings();
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final PassThroughLayer passThrough = new DefaultPassThroughLayer();
    private final ProxyFactoryAssembler proxyFactoryAssembler = new DefaultProxyFactoryAssembler();
    private final ProxyFactory proxyFactory = proxyFactoryAssembler.assemble();

    // FIX 1887 Remove the need to pass in the finder engine.
    public Spider assemble(InstanceMaster instancer, BlueprintMaster blueprinter) {
        ProviderEngine passThroughProvider = (ProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        ResolverEngine resolverEngine = assembleResolver(passThroughProvider, instancer, blueprinter);
        InjectorEngine injectorEngine = assembleInjector(resolverEngine);
        ProviderEngine providerEngine = assembleProvider(injectorEngine, instantiator);
        passThrough.setDelegate(providerEngine);
        Spider spider = buildSpider(providerEngine, resolverEngine, injectorEngine);
        return threadLocal(spider);
    }

    private Spider threadLocal(Spider spider) {
        TryCatchFinally trier = new SpiderTryCatchFinally(RESOLVED_THINGS);
        InvocationHandler handler = new DefaultTryCatchFinallyHandler(spider, trier);
        return (Spider) proxyFactory.newProxy(SPIDER_TYPE, handler);
    }

    private Spider buildSpider(ProviderEngine providerEngine,
            ResolverEngine resolverEngine,
            InjectorEngine injectorEngine
    ) {
        Provider provider = new DefaultProvider(providerEngine);
        Resolver resolver = new DefaultResolver(resolverEngine);
        Injector injector = new DefaultInjector(injectorEngine);
        return new DefaultSpider(provider, injector, resolver);
    }

    private ResolverEngine assembleResolver(ProviderEngine provider, InstanceMaster instancer, BlueprintMaster blueprinter) {
        NewerAssembler newerAssembler = new DefaultNewerAssembler(provider);
        // FIX BREADCRUMB 2081 Blueprints first everywhere.
        return new DefaultResolverEngine(provider, blueprinter, instancer, newerAssembler);
    }

    private InjectorEngine assembleInjector(ResolverEngine resolver) {
        return assembleResolverInjector(resolver);
    }

    private DefaultInjectorEngine assembleResolverInjector(ResolverEngine resolver) {
        ResolvableFieldFinder finder = new DefaultResolvableFieldFinder();
        FieldResolver fieldResolver = new DefaultFieldResolver(resolver);
        return new DefaultInjectorEngine(finder, fieldResolver);
    }

    private ProviderEngine assembleProvider(InjectorEngine injector, Instantiator instantiator) {
        Onionizer onionizer = new BermudaOnionizer();
        return new DefaultProviderEngine(onionizer, injector, instantiator);
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
