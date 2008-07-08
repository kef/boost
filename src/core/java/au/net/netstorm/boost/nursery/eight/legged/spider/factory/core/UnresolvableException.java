package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class UnresolvableException extends RuntimeException {
    private final InjectionSite site;

    public UnresolvableException(InjectionSite site) {
        this.site = site;
    }

    public InjectionSite getSite() {
        return site;
    }
}
