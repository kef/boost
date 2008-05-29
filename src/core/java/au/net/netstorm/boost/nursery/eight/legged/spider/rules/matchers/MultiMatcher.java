package au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class MultiMatcher implements Matcher {
    private final Matcher[] matchers;
    public MultiMatcher(Matcher... matchers) {
        this.matchers = matchers;
    }

    public boolean accept(InjectionSite site) {
        for (Matcher m : matchers) {
            if (!m.accept(site)) return false;
        }
        return true;
    }
}
