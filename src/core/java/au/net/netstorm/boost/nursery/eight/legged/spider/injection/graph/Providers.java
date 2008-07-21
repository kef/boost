package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.util.Set;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface Providers {
    // FIX 2394 name. provide?
    Provider getOrCreate(InjectionSite site);

    Provider get(InjectionSite site);

    Set<InjectionSite> keySet();

    void put(InjectionSite site, Provider provider);
}
