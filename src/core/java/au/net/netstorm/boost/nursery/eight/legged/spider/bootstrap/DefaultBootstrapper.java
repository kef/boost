package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultNu;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.DefaultGraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.ImplicitFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.Mappings;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.Mapping;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.DefaultMapping;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.DefaultSpidersWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.spider.core.DefaultSpider;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;

// DEBT ClassDataAbstractionCoupling {
public final class DefaultBootstrapper implements Bootstrapper {
    private final Web web;
    private final GraphBuilder builder;
    private final Nu nu;
    private final Injector injector;
    private final Resolver resolver;
    private final Spider spider;
    private final SpidersWeb spidersWeb;

    public DefaultBootstrapper(Web web, InjectionWeb injections) {
        this.web = web;
        this.builder = new DefaultGraphBuilder(injections);
        this.nu = new DefaultNu(builder);
        this.injector = new DefaultInjector(builder);
        this.resolver = new DefaultResolver(builder);
        this.spider = new DefaultSpider(nu, injector, resolver);
        this.spidersWeb = new DefaultSpidersWeb(web, spider);
    }

    public void apply(Web web) {
        // FIX 2394 is this really needed - i am thinking default rules behaviour will suffice
//        web.register(BlueprintedFactory.class);
        web.register(ImplicitFactory.class);
        web.register(this);
    }

    public void apply(Binder rule) {
        rule.bind(SpidersWeb.class).to(spidersWeb);
        rule.bind(Web.class).to(web);
        rule.bind(Spider.class).to(spider);
        rule.bind(GraphBuilder.class).to(builder);
        rule.bind(Resolver.class).to(resolver);
        rule.bind(Injector.class).to(injector);
        rule.bind(Nu.class).to(nu);
        configureImplicitFactory();
    }

    public SpidersWeb getBootstrappedWeb() {
        return spidersWeb;
    }

    private void configureImplicitFactory() {
        Mappings mappings = spider.resolve(Mappings.class);
        Mapping mapper = new DefaultMapping();
        mappings.add(mapper);
    }
}
// } DEBT ClassDataAbstractionCoupling