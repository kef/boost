package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.collections.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.resolver.FactoryResolver;

public final class LazyProviderCreator implements Creator<InjectionSite, Provider> {
    private final FactoryResolver resolver;

    public LazyProviderCreator(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Provider create(InjectionSite site) {
        Factory factory = resolver.resolve(site);
        return factory.nu(site);
    }
}
