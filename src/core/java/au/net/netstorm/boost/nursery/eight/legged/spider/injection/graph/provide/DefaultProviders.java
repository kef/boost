package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import java.util.Iterator;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultProviders extends Primordial implements Providers {
    private final IntegrityMap<InjectionSite, Provider> providers = new DefaultIntegrityMap<InjectionSite, Provider>();
    private final ProvisionFailer failer = new ProvisionFailer();
    private final Creator<InjectionSite, Provider> creator;

    public DefaultProviders(Creator<InjectionSite, Provider> creator) {
        this.creator = creator;
    }

    public Provider provide(InjectionSite site) {
        return providers.get(site, creator);
    }

    public Provider get(InjectionSite site) {
        return providers.get(site, failer);
    }

    public void put(InjectionSite site, Provider provider) {
        providers.put(site, provider);
    }

    public Iterator<InjectionSite> iterator() {
        return providers.iterator();
    }
}
