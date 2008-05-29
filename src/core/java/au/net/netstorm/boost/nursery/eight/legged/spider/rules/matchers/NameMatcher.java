package au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class NameMatcher implements Matcher {
    private final String name;

    public NameMatcher(String name) {
        this.name = name;
    }

    public boolean accept(InjectionSite site) {
        String actual = site.name();
        return name.equals(actual);
    }
}
