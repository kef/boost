package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class LazyProviderCreator extends Primordial implements Creator<InjectionSite, Provider> {
    private final FactoryResolver resolver;

    public LazyProviderCreator(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Provider create(InjectionSite site) {
        Factory factory = resolver.resolve(site);
        return factory.nu(site);
    }
}