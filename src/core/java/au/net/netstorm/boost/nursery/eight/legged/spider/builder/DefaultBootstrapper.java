package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter.Aspector;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter.DefaultAspector;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspects;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.DefaultAspects;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.DefaultAspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.types.lifecycle.ConstructableAspect;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.DefaultBinder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.DefaultBindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.DefaultFactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultNu;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultNuImpl;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.DefaultFactories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.DefaultMapping;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.ImplicitFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.Mapping;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.Mappings;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core.DefaultGrapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core.Grapher;
import au.net.netstorm.boost.spider.core.Constructable;
import au.net.netstorm.boost.spider.core.DefaultSpider;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 2394 MAG Interesting little beast.  Bit of wiring hey ;)
// FIX 2394 see if this can be split
// DEBT ClassDataAbstractionCoupling|NCSS {
public final class DefaultBootstrapper implements Bootstrapper {
    private final Aspects aspects = new DefaultAspects();
    private final Bindings bindings = new DefaultBindings();
    private final Factories factories = new DefaultFactories();
    private final FactoryResolver factoryResolver = new DefaultFactoryResolver(bindings, factories);
    private final AspectResolver aspectResolver = new DefaultAspectResolver(aspects);
    private final Grapher grapher = new DefaultGrapher(factoryResolver, aspectResolver);
    private final Nu nu = new DefaultNu(grapher);
    private final NuImpl nuImpl = new DefaultNuImpl(grapher);
    private final Binder binder = new DefaultBinder(bindings);
    private final Aspector aspector = new DefaultAspector(aspects);
    private final Web web = new DefaultWeb(nuImpl, binder, factories);
    private final Injector injector = new DefaultInjector(grapher);
    private final Resolver resolver = new DefaultResolver(grapher);
    private final Spider spider = new DefaultSpider(nu, injector, resolver);

    public Spider bootstrap(Class<? extends SpiderConfig>[] configs) {
        bindImplicitFactory();
        bindSpiderState();
        bindAspects();
        loadConfigs(configs);
        return spider;
    }

    private void loadConfigs(Class<? extends SpiderConfig>[] configs) {
        for (Class<? extends SpiderConfig> config : configs) web.configure(config);
    }

    // FIX 2394 this bit should probably be in a BoostSpiderConfig
    private void bindImplicitFactory() {
        web.register(ImplicitFactory.class);
        Mappings mappings = spider.resolve(Mappings.class);
        Mapping mapper = new DefaultMapping();
        mappings.add(mapper);
    }

    // FIX 2394 could also go into a BoostSpiderConfig
    private void bindAspects() {
        aspector.cut(Constructable.class, ConstructableAspect.class);
    }

    private void bindSpiderState() {
        binder.bind(Web.class).to(web);
        binder.bind(Spider.class).to(spider);
        binder.bind(Resolver.class).to(resolver);
        binder.bind(Injector.class).to(injector);
        binder.bind(Nu.class).to(nu);
        binder.bind(NuImpl.class).to(nuImpl);
        binder.bind(Binder.class).to(binder);
        binder.bind(Factories.class).to(factories);
        binder.bind(Bindings.class).to(bindings);
        binder.bind(FactoryResolver.class).to(factoryResolver);
        binder.bind(Grapher.class).to(grapher);
        binder.bind(Aspector.class).to(aspector);
        binder.bind(Aspects.class).to(aspects);
        binder.bind(AspectResolver.class).to(aspectResolver);
    }
}
// } DEBT ClassDataAbstractionCoupling|NCSS