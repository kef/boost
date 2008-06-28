package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.HasParameters;

public final class ConstuctorInjectorFactory implements InjectorFactory<ConstructorInjector> {
    private final InjectionSiteBuilder siteBuilder = new DefaultInjectionSiteBuilder();

    public ConstructorInjector nu(InjectionWeb web, InjectionSite site, Provider provider) {
        InjectionSite[] sites = provider instanceof HasParameters ? params(site, provider) : new InjectionSite[0];
        return nuConstuctor(web, provider, sites);
    }

    private ConstructorInjector nuConstuctor(InjectionWeb web, Provider provider, InjectionSite[] sites) {
        Injection[] injections = new Injection[sites.length];
        for (int i = 0; i < sites.length; ++i) {
            injections[i] = web.injection(sites[i]);
        }
        return new DefaultConstructorInjector(provider, injections);
    }

    private InjectionSite[] params(InjectionSite site, Provider provider) {
        HasParameters parameterized = (HasParameters) provider;
        Type[] types = parameterized.getParameterTypes();
        InjectionType type = site.type();
        Class<?> cls = type.rawClass();
        return siteBuilder.build(cls, types);
    }
}
