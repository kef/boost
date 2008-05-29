package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.DefaultSpidersWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.BlueprintedFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ImpliedFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration.Ruler;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.DefaultGraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultNu;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultResolver;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.core.DefaultSpider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;

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
        web.register(BlueprintedFactory.class);
        web.register(ImpliedFactory.class);
        web.register(this);
    }

    public void apply(Ruler rule) {
        rule.map(SpidersWeb.class).to(spidersWeb);
        rule.map(Web.class).to(web);
        rule.map(Spider.class).to(spider);
        rule.map(GraphBuilder.class).to(builder);
        rule.map(Resolver.class).to(resolver);
        rule.map(Injector.class).to(injector);
        rule.map(Nu.class).to(nu);
    }

    public SpidersWeb getBootstrappedWeb() {
        return spidersWeb;
    }
}
