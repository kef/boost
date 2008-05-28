package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.DefaultConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultConstructingInjection implements ConstructingInjection {
    private final ConstructorInjector constructor;

    public DefaultConstructingInjection(InjectionWeb web, InjectionSite site, InjectionSiteBuilder builder) {
        this.constructor = buildInjector(web, site, builder);
    }

    public Object apply() {
        return constructor.inject();
    }

    private ConstructorInjector buildInjector(InjectionWeb web, InjectionSite site, InjectionSiteBuilder builder) {
        Provider provider = web.provider(site);
        InjectionType type = site.type();
        Constructor<?> ctor = type.getConstructor();
        InjectionSite[] sites = builder.build(ctor);
        Injection[] injections = new Injection[sites.length];
        for (int i = 0; i < sites.length; ++i) {
            injections[i] = web.injection(sites[i]);
        }
        return new DefaultConstructorInjector(provider, injections);
    }
}
