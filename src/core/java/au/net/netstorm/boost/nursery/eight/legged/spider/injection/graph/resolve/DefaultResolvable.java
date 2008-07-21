package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultResolvable implements Resolvable {
    private final InjectionSite host;
    private final InjectionSite[] sites;

    public DefaultResolvable(InjectionSite host, InjectionSite[] sites) {
        this.host = host;
        this.sites = sites;
    }

    public InjectionSite host() {
        return host;
    }

    public InjectionSite[] sites() {
        return sites;
    }
}
