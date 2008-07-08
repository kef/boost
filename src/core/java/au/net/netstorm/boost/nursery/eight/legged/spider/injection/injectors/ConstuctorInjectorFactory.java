package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.HasParameters;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;

public final class ConstuctorInjectorFactory implements InjectorFactory<ConstructorInjector> {
    private final ProviderOperations operations = new DefaultProviderOperations();

    public ConstructorInjector nu(InjectionWeb web, InjectionSite site, Provider provider) {
        // FIX 2394 marker interfaces have to go, providers are wrapped by aspecty providers, markers not maintained
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
        return operations.constructors(site, provider);
    }
}
