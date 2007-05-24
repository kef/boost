package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.demo.spider.core.DefaultSpider;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.core.CitizenInjectorEngine;
import au.net.netstorm.boost.spider.core.DefaultProvider;
import au.net.netstorm.boost.spider.core.DefaultProviderEngine;
import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.core.ProviderEngine;
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
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultOldPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.OldPassThroughLayer;
import au.net.netstorm.boost.spider.resolve.DefaultResolver;
import au.net.netstorm.boost.spider.resolve.DefaultResolverEngine;
import au.net.netstorm.boost.spider.resolve.DefaultSpiderWeb;
import au.net.netstorm.boost.spider.resolve.DefaultWebSpinner;
import au.net.netstorm.boost.spider.resolve.FinderEngine;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.spider.resolve.SpiderWeb;
import au.net.netstorm.boost.spider.resolve.WebSpinner;
import au.net.netstorm.boost.spider.resolve.WebSpinnerEngine;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultSpiderAssembler implements SpiderAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ProviderEngine.class);
    private final OldPassThroughLayer passThrough = new DefaultOldPassThroughLayer();
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final ProxyFactory proxyFactory = assembleProxyFactory();
    private final Interface citizen;

    public DefaultSpiderAssembler(Class citizen) {
        this.citizen = new DefaultInterface(citizen);
    }

    public Spider assemble() {
        ProviderEngine passThroughProvider = (ProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        WebSpinner webSpinner = brandNewWeb();
        ResolverEngine resolverEngine = assembleResolver(passThroughProvider, webSpinner);
        InjectorEngine injectorEngine = assembleInjector(resolverEngine);
        ProviderEngine providerEngine = assembleProvider(injectorEngine, instantiator);
        passThrough.setDelegate(providerEngine);
        return buildSpider(providerEngine, resolverEngine, injectorEngine, webSpinner);
    }

    private Spider buildSpider(ProviderEngine providerEngine,
            ResolverEngine resolverEngine,
            InjectorEngine injectorEngine,
            WebSpinnerEngine spinnerEngine) {
        Provider provider = new DefaultProvider(providerEngine);
        Resolver resolver = new DefaultResolver(resolverEngine);
        Injector injector = new DefaultInjector(injectorEngine);
        SpiderWeb web = new DefaultSpiderWeb(spinnerEngine);
        return new DefaultSpider(provider, injector, resolver, web);
    }

    private WebSpinner brandNewWeb() {
        return new DefaultWebSpinner();
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
