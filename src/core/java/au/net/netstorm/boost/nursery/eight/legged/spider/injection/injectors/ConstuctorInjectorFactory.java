package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

public final class ConstuctorInjectorFactory implements InjectorFactory<ConstructorInjector> {
    private final InjectionSiteBuilder siteBuilder = new DefaultInjectionSiteBuilder();

    public ConstructorInjector nu(InjectionWeb web, InjectionSite site) {
        InjectionType type = site.type();
        Provider provider = web.provider(site);
        Constructor<?> ctor = type.getConstructor();
        InjectionSite[] sites = siteBuilder.build(ctor);
        return nuConstuctor(web, provider, sites);
    }

    private ConstructorInjector nuConstuctor(InjectionWeb web, Provider provider, InjectionSite[] sites) {
        Injection[] injections = new Injection[sites.length];
        for (int i = 0; i < sites.length; ++i) {
            injections[i] = web.injection(sites[i]);
        }
        return new DefaultConstructorInjector(provider, injections);
    }
}
