package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.util.Set;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface Providers {
    Provider get(InjectionSite site, Creator<InjectionSite, Provider> creator);

    Provider get(InjectionSite site);

    Set<InjectionSite> keySet();

    void put(InjectionSite site, Provider provider);
}
