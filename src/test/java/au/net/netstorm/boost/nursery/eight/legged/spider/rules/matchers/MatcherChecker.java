package au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface MatcherChecker {
    void checkAccept(Matcher subject, boolean expected, InjectionSite site);
}
