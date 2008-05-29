package au.net.netstorm.boost.spider.builder;

import au.net.netstorm.boost.gunge.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.spider.inject.resolver.core.DefaultFieldResolver;
import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.nursery.spider.onion.core.BermudaOnionizer;
import au.net.netstorm.boost.spider.resolve.DefaultResolverEngine;
import au.net.netstorm.boost.spider.core.DefaultProviderEngine;
import au.net.netstorm.boost.spider.core.OldDefaultSpider;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.core.SpiderTryFinally;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.spider.core.DefaultNu;
import au.net.netstorm.boost.spider.inject.core.DefaultInjector;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.core.DefaultInjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.spider.instance.PartialInstances;
import au.net.netstorm.boost.spider.instantiate.DefaultNuImpl;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.spider.onion.layer.closure.DefaultTryFinallyLayer;
import au.net.netstorm.boost.spider.onion.layer.closure.TryFinally;
import au.net.netstorm.boost.spider.onion.layer.closure.TryFinallyLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.resolve.DefaultResolver;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.spider.resolve.ImplementationLookup;
import au.net.netstorm.boost.spider.resolve.DefaultImplementationLookup;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;

// SUGGEST: No need to return everything, just register the relevant parts as part of construction ;)

// FIX 2215 Why is this class in "demo"?  It's some sort of wirer?!

// FIX 2394 this needs significant work to be unwound from itself, main problem is that you can't utilize
// FIX 2394 resolver when there are no factories registered, even if there are valid complete instances
// FIX 2394 highlights needs for an "instance" factory rather than shoe-horning through blueprints

// FIX BREADCRUMB 2394 currently unwinding this mess
// DEBT DataAbstractionCoupling|ParameterNumber {
public final class DefaultSpiderAssembler implements SpiderAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ProviderEngine.class);
    private static final Interface SPIDER_TYPE = new DefaultInterface(Spider.class);
    private static final PartialInstances PARTIAL_INSTANCES = new DefaultPartialInstances();
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final PassThroughLayer passThrough = new DefaultPassThroughLayer();
    private final ProxyFactory proxyFactory = new DefaultProxyFactory();

    public Spider assemble(Instances instances, Factories factories, Blueprints blueprints, Layers proxies) {
        ProviderEngine passThroughProvider = (ProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        ResolverEngine resolverEngine = assembleResolver(passThroughProvider, instances, factories);
        InjectorEngine injectorEngine = assembleInjector(resolverEngine);
        ProviderEngine providerEngine = assembleProvider(injectorEngine, instantiator, proxies);
        passThrough.setDelegate(providerEngine);
        Spider spider =
                buildSpider(instances, factories, blueprints, proxies, resolverEngine, injectorEngine, providerEngine);
        return threadLocal(spider);
    }

    private Spider buildSpider(Instances instances, Factories factories, Blueprints blueprints, Layers proxies,
            ResolverEngine resolverEngine, InjectorEngine injectorEngine, ProviderEngine providerEngine) {
        NuImpl nuImpl = new DefaultNuImpl(providerEngine);
        Registry registry = assembleRegistry(instances, factories, blueprints, proxies, nuImpl);
        Nu nu = bootStrapNu(registry, factories, nuImpl);
        Injector injector = bootStrapInjector(registry, injectorEngine);
        Resolver resolver = assembleResolver(registry, resolverEngine);
        return new OldDefaultSpider(nu, injector, resolver, registry);
    }

    private Resolver assembleResolver(Registry registry, ResolverEngine resolverEngine) {
        Resolver resolver = new DefaultResolver(resolverEngine);
        registry.instance(Resolver.class, resolver);
        return resolver;
    }

    private Registry assembleRegistry(Instances instances, Factories factories, Blueprints blueprints, Layers proxies,
            NuImpl nuImpl) {
        Registry registry = new DefaultRegistry(blueprints, instances, factories, proxies, nuImpl);
        registry.instance(Registry.class, registry);
        registry.instance(NuImpl.class, nuImpl);
        return registry;
    }

    private Injector bootStrapInjector(Registry registry, InjectorEngine injectorEngine) {
        Injector injector = new DefaultInjector(injectorEngine);
        registry.instance(Injector.class, injector);
        return injector;
    }

    private Nu bootStrapNu(Registry registry, Factories factories, NuImpl nuImpl) {
        LinkageFactory linkages = new DefaultLinkageFactory();
        ImplementationLookup lookup = new DefaultImplementationLookup(factories, linkages);
        Nu nu = new DefaultNu(lookup, nuImpl);
        registry.instance(ImplementationLookup.class, lookup);
        registry.instance(Nu.class, nu);
        return nu;
    }

    private Spider threadLocal(Spider spider) {
        TryFinally trier = new SpiderTryFinally(PARTIAL_INSTANCES);
        TryFinallyLayer layer = new DefaultTryFinallyLayer(spider, trier);
        return (Spider) proxyFactory.newProxy(SPIDER_TYPE, layer);
    }

    private ResolverEngine assembleResolver(ProviderEngine provider, Instances instances, Factories factories) {
        return new DefaultResolverEngine(instances, factories, provider);
    }

    private InjectorEngine assembleInjector(ResolverEngine resolver) {
        ResolvableFieldFinder finder = new DefaultResolvableFieldFinder();
        FieldResolver fieldResolver = new DefaultFieldResolver(resolver);
        return new DefaultInjectorEngine(finder, fieldResolver);
    }

    private ProviderEngine assembleProvider(InjectorEngine injector, Instantiator instantiator, Layers proxies) {
        Onionizer onionizer = new BermudaOnionizer();
        return new DefaultProviderEngine(onionizer, injector, instantiator, proxies);
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