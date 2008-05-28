package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections.DefaultIntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver.RuleResolver;

public final class DefaultInjectionContext implements InjectionContext {
    private final IntegrityMap<InjectionSite, Provider> providers =
            new DefaultIntegrityMap<InjectionSite, Provider>();
    private final IntegrityMap<InjectionSite, Injection> injections =
            new DefaultIntegrityMap<InjectionSite, Injection>();
    private final RuleResolver resolver;

    public DefaultInjectionContext(RuleResolver resolver) {
        this.resolver = resolver;
    }

    public Provider provider(InjectionSite site) {
        Creator<Provider> creator = new LazyProviderCreator(site, resolver);
        return providers.getOrCreate(site, creator);
    }

    public Injection injection(InjectionSite site) {
        Creator<Injection> creator = new LazyInjectionCreator(site);
        return injections.getOrCreate(site, creator);
    }
}
