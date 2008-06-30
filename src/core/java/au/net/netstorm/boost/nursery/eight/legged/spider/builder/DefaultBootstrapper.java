package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.DefaultBinder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultNu;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultNuImpl;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.DefaultMapping;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.ImplicitFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.Mapping;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.Mappings;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.DefaultGraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.DefaultWeb;
import au.net.netstorm.boost.spider.core.DefaultSpider;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 2394 see if this can be split
// DEBT ClassDataAbstractionCoupling {
public final class DefaultBootstrapper implements Bootstrapper {
    private final Web web;
    private final GraphBuilder builder;
    private final Nu nu;
    private final NuImpl nuImpl;
    private final Injector injector;
    private final Resolver resolver;
    private final Spider spider;
    private final SpiderEgg egg;
    private final Binder binder;

    public DefaultBootstrapper(Bindings bindings, Factories factories, InjectionWeb injections) {
        this.builder = new DefaultGraphBuilder(injections);
        this.nu = new DefaultNu(builder);
        this.nuImpl = new DefaultNuImpl(builder);
        this.binder = new DefaultBinder(bindings);
        this.web = new DefaultWeb(nuImpl, binder, factories);
        this.injector = new DefaultInjector(builder);
        this.resolver = new DefaultResolver(builder);
        this.spider = new DefaultSpider(nu, injector, resolver);
        this.egg = new DefaultSpiderEgg(web, spider);
    }

    public void bootstrap() {
        bindImplicitFactory();
        bindSpiderState();
    }

    public SpiderEgg getBootstrappedWeb() {
        return egg;
    }

    private void bindImplicitFactory() {
        web.register(ImplicitFactory.class);
        Mappings mappings = spider.resolve(Mappings.class);
        Mapping mapper = new DefaultMapping();
        mappings.add(mapper);
    }

    private void bindSpiderState() {
        binder.bind(SpiderEgg.class).to(egg);
        binder.bind(Web.class).to(web);
        binder.bind(Spider.class).to(spider);
        binder.bind(GraphBuilder.class).to(builder);
        binder.bind(Resolver.class).to(resolver);
        binder.bind(Injector.class).to(injector);
        binder.bind(Nu.class).to(nu);
        binder.bind(NuImpl.class).to(nuImpl);
        binder.bind(Binder.class).to(binder);
    }
}
// } DEBT ClassDataAbstractionCoupling