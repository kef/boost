package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ConfigurableFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultWebAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Web subject;
    FieldTestUtil fielder;
    EdgeClass classerMock;
    Factories factoriesMock;
    Bindings bindingsMock;
    RuleConfig ruleConfigMock;
    Factory factoryMock;
    Binder binderMock;
    ConfigurableFactory configurableFactoryMock;

    public void setUpFixtures() {
        subject = new DefaultWeb(bindingsMock, factoriesMock);
        fielder.setInstance(subject, "classer", classerMock);
        fielder.setInstance(subject, "binder", binderMock);
    }

    public void testBinder() {
        Binder actual = subject.binder();
        assertEquals(binderMock, actual);
    }

    public void testRegisterRuleConfig() {
        expect.oneCall(ruleConfigMock, VOID, "apply", binderMock);
        subject.register(ruleConfigMock);
    }

    public void testRegisterFactory() {
        expect.oneCall(classerMock, factoryMock, "newInstance", MockFactory.class);
        expect.oneCall(factoriesMock, VOID, "add", factoryMock);
        subject.register(MockFactory.class);
    }

    public void testRegisterConfigurableFactory() {
        expect.oneCall(configurableFactoryMock, VOID, "configure", binderMock);
        expect.oneCall(factoriesMock, VOID, "add", configurableFactoryMock);
        subject.register(configurableFactoryMock);
    }
}
