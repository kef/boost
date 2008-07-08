package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.util.Set;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.Creator;

public final class DefaultProviders implements Providers {
    private final IntegrityMap<InjectionSite, Provider> providers = new DefaultIntegrityMap<InjectionSite, Provider>();

    public Provider get(InjectionSite site, Creator<InjectionSite, Provider> creator) {
        return providers.get(site, creator);
    }

    public Provider get(InjectionSite site) {
        return providers.get(site);
    }

    public Set<InjectionSite> keySet() {
        return providers.keySet();
    }

    public void put(InjectionSite site, Provider provider) {
        providers.put(site, provider);
    }
}
