package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultGraphBuilder implements GraphBuilder {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final InjectionWeb web;

    public DefaultGraphBuilder(InjectionWeb web) {
        this.web = web;
    }

    public <T> InjectionGraph<T> build(Class<T> root, InjectionType type, Object... args) {
        InjectionSite site = builder.build(type);
        // FIX 2394 need to tweek the root injection to allow args
        Injection injection = web.injection(site);
        return new DefaultInjectionGraph<T>(root, injection);
    }
}
