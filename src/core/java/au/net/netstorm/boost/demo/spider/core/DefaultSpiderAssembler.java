package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.nursery.spider.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.nursery.spider.onion.core.BermudaOnionizer;
import au.net.netstorm.boost.spider.core.DefaultProviderEngine;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.core.SpiderTryCatchFinally;
import au.net.netstorm.boost.spider.inject.core.DefaultInjector;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.core.DefaultInjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.spider.instantiate.DefaultNu;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.spider.onion.layer.closure.DefaultTryCatchFinallyHandler;
import au.net.netstorm.boost.spider.onion.layer.closure.TryCatchFinally;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.resolve.DefaultResolver;
import au.net.netstorm.boost.spider.resolve.DefaultResolverEngine;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactoryAssembler;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactoryAssembler;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

import java.lang.reflect.InvocationHandler;

// SUGGEST: No need to return everything, just register the relevant parts as part of construction ;)

// FIX 2215 Why is this class in "demo"?  It's some sort of wirer?!

// DEBT DataAbstractionCoupling {
public final class DefaultSpiderAssembler implements SpiderAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ProviderEngine.class);
    private static final Interface SPIDER_TYPE = new DefaultInterface(Spider.class);
    private static final PartialInstances PARTIAL_INSTANCES = new DefaultPartialInstances();
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final PassThroughLayer passThrough = new DefaultPassThroughLayer();
    private final ProxyFactoryAssembler proxyFactoryAssembler = new DefaultProxyFactoryAssembler();
    private final ProxyFactory proxyFactory = proxyFactoryAssembler.assemble();

    // SUGGEST: Move the creation/registration of the factories up one level.  Use the registry.
    public Spider assemble(Instances instances, Factories factories) {
        ProviderEngine passThroughProvider = (ProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        ResolverEngine resolverEngine = assembleResolver(passThroughProvider, instances, factories);
        InjectorEngine injectorEngine = assembleInjector(resolverEngine);
        ProviderEngine providerEngine = assembleProvider(injectorEngine, instantiator);
        passThrough.setDelegate(providerEngine);
        Spider spider = buildSpider(providerEngine, resolverEngine, injectorEngine);
        return threadLocal(spider);
    }

    private Spider threadLocal(Spider spider) {
        TryCatchFinally trier = new SpiderTryCatchFinally(PARTIAL_INSTANCES);
        InvocationHandler handler = new DefaultTryCatchFinallyHandler(spider, trier);
        return (Spider) proxyFactory.newProxy(SPIDER_TYPE, handler);
    }

    private Spider buildSpider(
            ProviderEngine providerEngine,
            ResolverEngine resolverEngine,
            InjectorEngine injectorEngine
    ) {
        Nu nu = new DefaultNu(providerEngine);
        Resolver resolver = new DefaultResolver(resolverEngine);
        Injector injector = new DefaultInjector(injectorEngine);
        return new DefaultSpider(nu, injector, resolver);
    }

    private ResolverEngine assembleResolver(
            ProviderEngine provider,
            Instances instances,
            Factories factories) {
        return new DefaultResolverEngine(instances, factories, provider);
    }

    private InjectorEngine assembleInjector(ResolverEngine resolver) {
        return assembleResolverInjector(resolver);
    }

    private InjectorEngine assembleResolverInjector(ResolverEngine resolver) {
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
// } DEBT DataAbstractionCoupling