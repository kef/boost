package au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class NameMatcherAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Matcher subject;
    MatcherChecker checker;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject = new NameMatcher("foo");
    }

    public void testAccept() {
        expect.oneCall(siteMock, "foo", "name");
        checker.checkAccept(subject, true, siteMock);
    }

    public void testDoNotAccept() {
        expect.oneCall(siteMock, "bar", "name");
        checker.checkAccept(subject, false, siteMock);
    }
}