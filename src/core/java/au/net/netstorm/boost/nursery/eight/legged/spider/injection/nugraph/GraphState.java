package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface GraphState {
    Provider provide(InjectionSite site);

    void resolvable(InjectionSite host, InjectionSite[] sites);

    void add(InjectionSite site, Provider provider);

    void walking(InjectionSite site);

    boolean hasWalked(InjectionSite site);
}
