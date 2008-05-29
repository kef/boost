package au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import static junit.framework.Assert.assertEquals;

public final class DefaultMatcherChecker implements MatcherChecker {
    public void checkAccept(Matcher subject, boolean expected, InjectionSite site) {
        boolean result = subject.accept(site);
        assertEquals(expected, result);
    }
}
