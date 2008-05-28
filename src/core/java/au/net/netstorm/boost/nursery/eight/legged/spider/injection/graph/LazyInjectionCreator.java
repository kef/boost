package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class LazyInjectionCreator implements Creator<Injection> {
    private final InjectionSite site;

    public LazyInjectionCreator(InjectionSite site) {
        this.site = site;
    }

    public Injection create() {
        // FIX 2394 where does build get called from
        return new DefaultInjection(site);
    }
}
