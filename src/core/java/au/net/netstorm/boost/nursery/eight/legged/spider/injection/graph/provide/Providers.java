package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface Providers extends Iterable<InjectionSite> {
    Provider provide(InjectionSite site);

    Provider get(InjectionSite site);

    void put(InjectionSite site, Provider provider);

    void replace(InjectionSite site, Provider provider);
}
