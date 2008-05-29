package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration.Ruler;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration.DefaultRuler;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration.MockClassEquals;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ConfigurableFactory;

public final class DefaultWebAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Web subject;
    Rules rulesMock;
    RuleConfig ruleConfigMock;
    Factory factoryMock;
    ConfigurableFactory configurableMock;

    public void setUpFixtures() {
        subject = new DefaultWeb(rulesMock);
    }

    public void testRegisterRuleConfig() {
        expect.oneCall(ruleConfigMock, VOID, "apply", new MockClassEquals(DefaultRuler.class));
        subject.register(ruleConfigMock);
    }

    public void testRegisterFactoryClass() {
        MockFactory expected = new MockFactory();
        expect.oneCall(rulesMock, VOID, "addWildcard", expected);
        subject.register(MockFactory.class);
    }

    public void testRegisterFactory() {
        expect.oneCall(rulesMock, VOID, "addWildcard", factoryMock);
        subject.register(factoryMock);
    }

    public void testRegisterConfigurableFactory() {
        expect.oneCall(rulesMock, VOID, "addWildcard", configurableMock);
        expect.oneCall(configurableMock, VOID, "configure", subject);
        subject.register(configurableMock);
    }

    public void testRule() {
        Ruler result = subject.rule();
        assertEquals(true, result instanceof DefaultRuler);
    }
}
