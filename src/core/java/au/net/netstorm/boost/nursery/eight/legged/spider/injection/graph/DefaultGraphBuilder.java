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

    public Injection build(InjectionType type) {
        InjectionSite site = builder.build(type);
        return web.injection(site);
    }
}
