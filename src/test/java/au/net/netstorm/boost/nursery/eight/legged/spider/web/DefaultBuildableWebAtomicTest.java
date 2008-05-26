package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ConfigurableFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.RuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.SingleRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.MultiRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;

public final class DefaultBuildableWebAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private BuildableWeb subject;
    FieldTestUtil fielder;
    EdgeClass classerMock;
    Factories factoriesMock;
    Rules rulesMock;
    Rule ruleMock;
    Factory factoryMock;
    ConfigurableFactory configurableMock;

    public void setUpFixtures() {
        subject = new DefaultBuildableWeb();
        fielder.setInstance(subject, "classer", classerMock);
        fielder.setInstance(subject, "factories", factoriesMock);
        fielder.setInstance(subject, "rules", rulesMock);
    }

    public void testBuilder() {
        GraphBuilder result = subject.builder();
        // FIX 2394 simple factory method, need to make sure it is valid builder handed back
    }

    public void testSingle() {
        RuleBuilder builder = subject.single();
        checkRuleBuilder(builder, SingleRuleBuilder.class);
    }

    public void testMulti() {
        RuleBuilder builder = subject.multi();
        checkRuleBuilder(builder, MultiRuleBuilder.class);
    }

    public void testRegisterRule() {
        expect.oneCall(rulesMock, VOID, "add", ruleMock);
        subject.register(ruleMock);
    }

    public void testRegisterFactoryType() {
        DummyFactory dummyFactory = new DummyFactory();
        expect.oneCall(classerMock, dummyFactory, "newInstance", DummyFactory.class);
        expect.oneCall(factoriesMock, VOID, "add", dummyFactory);
        subject.register(DummyFactory.class);
    }

    public void testRegisterFactory() {
        expect.oneCall(factoriesMock, VOID, "add", factoryMock);
        subject.register(factoryMock);
    }

    public void testRegisterConfigurableFactory() {
        expect.oneCall(factoriesMock, VOID, "add", configurableMock);
        expect.oneCall(configurableMock, VOID, "configure", subject);
        subject.register(configurableMock);
    }

    private void checkRuleBuilder(RuleBuilder builder, Class<?> expected) {
        Class<?> result = builder.getClass();
        boolean assignable = expected.isAssignableFrom(result);
        assertEquals(true, assignable);
    }
}
