package au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration.TreeHolder;

public final class HostMatcherAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Matcher subject;
    InjectionSite siteMock;
    MatcherChecker checker;

    public void setUpFixtures() {
        subject = new HostMatcher(TreeHolder.class);
    }

    public void testAccept() {
        expect.oneCall(siteMock, TreeHolder.class, "host");
        checker.checkAccept(subject, true, siteMock);
    }

    public void testDoNotAccept() {
        expect.oneCall(siteMock, String.class, "host");
        checker.checkAccept(subject, false, siteMock);
    }
}
