package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class LazyRuleAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private KeyedRule subject;
    RuleBuilder builderMock;
    KeyedRule delegateMock;
    InjectionType typeMock;
    Factory factoryMock;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject = new LazyRule(builderMock);
    }

    public void testKey() {
        expect.oneCall(builderMock, delegateMock, "build");
        expect.oneCall(delegateMock, typeMock, "key");
        assertSame(typeMock, subject.key());
    }

    public void testFactory() {
        expect.oneCall(builderMock, delegateMock, "build");
        expect.oneCall(delegateMock, factoryMock, "getFactory");
        assertSame(factoryMock, subject.getFactory());
    }

    public void testAccepts() {
        expect.oneCall(builderMock, delegateMock, "build");
        expect.oneCall(delegateMock, true, "accepts", siteMock);
        assertEquals(true, subject.accepts(siteMock));
    }
}
