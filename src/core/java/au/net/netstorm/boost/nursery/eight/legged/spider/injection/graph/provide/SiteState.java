package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface SiteState {
    void walking(InjectionSite site);

    boolean hasWalked(InjectionSite site);
}
