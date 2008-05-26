package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.InstanceProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.NuInjectionGraph;

public final class BootstrapFactory implements Factory {
    private final Provider provider;

    public BootstrapFactory(NuInjectionGraph nu) {
        this.provider = new InstanceProvider(nu);
    }

    public Provider nu(InjectionSite site) {
        if (!canHandle(site)) throw new IllegalArgumentException();
        return provider;
    }

    public boolean canHandle(InjectionSite site) {
        return site.isType(NuInjectionGraph.class);
    }
}
