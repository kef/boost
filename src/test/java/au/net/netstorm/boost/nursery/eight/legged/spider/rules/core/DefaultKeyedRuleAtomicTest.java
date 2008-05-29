package au.net.netstorm.boost.nursery.eight.legged.spider.rules.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.Matcher;

public final class DefaultKeyedRuleAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private KeyedRule subject;
    InjectionType typeMock;
    Factory factoryMock;
    Matcher matcherMock;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject = new DefaultKeyedRule(typeMock, factoryMock, matcherMock);
    }

    public void testKeyedRule() {
        checkKey(typeMock);
        checkFactory(factoryMock);
        checkMatcher(true);
        checkMatcher(false);
    }

    private void checkKey(InjectionType expected) {
        assertSame(expected, subject.key());
    }

    private void checkFactory(Factory expected) {
        assertSame(expected, subject.getFactory());
    }

    private void checkMatcher(boolean expected) {
        expect.oneCall(matcherMock, expected, "accept", siteMock);
        subject.accepts(siteMock);
    }
}
