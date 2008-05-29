package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
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

    public <T> InjectionGraph<T> resolve(Class<T> root, InjectionType type) {
        InjectionSite site = builder.build(type);
        Injection injection = web.injection(site);
        return new DefaultInjectionGraph<T>(root, injection);
    }

    public <T> InjectionGraph<T> nu(Class<T> root, InjectionType type, Object... args) {
        InjectionSite site = builder.build(type);
        Injection injection = new ParameterizedInjection(web, site, args);
        return new DefaultInjectionGraph<T>(root, injection);
    }

    public <T> InjectionGraph<T> inject(Class<T> root, InjectionType type, Object instance) {
        InjectionSite site = builder.build(type);
        Injection injection = new InstantiatedInjection(web, site, instance);
        return new DefaultInjectionGraph<T>(root, injection);
    }
}
