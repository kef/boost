package au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class MultiMatcherAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Matcher subject;
    MatcherChecker checker;
    Matcher matcherMock;
    Matcher anotherMock;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject = new MultiMatcher(matcherMock, anotherMock);
    }

    public void testAccept() {
        setExpectation(matcherMock, true);
        setExpectation(anotherMock, true);
        checker.checkAccept(subject, true, siteMock);
    }

    public void testDoNotAcceptFirstMatcher() {
        setExpectation(matcherMock, false);
        checker.checkAccept(subject, false, siteMock);
    }

    public void testDoNotAcceptOtherMatcher() {
        setExpectation(matcherMock, true);
        setExpectation(anotherMock, false);
        checker.checkAccept(subject, false, siteMock);
    }

    private void setExpectation(Matcher mock, boolean expected) {
        expect.oneCall(mock, expected, "accept", siteMock);
    }
}