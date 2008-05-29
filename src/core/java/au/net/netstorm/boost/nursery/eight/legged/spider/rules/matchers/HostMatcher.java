package au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class HostMatcher implements Matcher {
    private final Class<?> host;

    public HostMatcher(Class<?> host) {
        this.host = host;
    }

    public boolean accept(InjectionSite site) {
        Class<?> actual = site.host();
        return host.equals(actual);
    }
}
