package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;

public final class DefaultRulerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Ruler subject;
    InjectionTypeBuilder builder;
    Rules rulesMock;
    InjectionType typeMock;

    public void setUpFixtures() {
        subject = new DefaultRuler(rulesMock);
    }

    public void testMapClass() {
        InjectionType type = builder.build(Tree.class);
        Rule expected = new MockRule(type);
        expect.oneCall(rulesMock, VOID, "add", expected);
        subject.map(Tree.class);
    }

    public void testMapInjectionType() {
        Rule expected = new MockRule(typeMock);
        expect.oneCall(rulesMock, VOID, "add", expected);
        subject.map(typeMock);
    }
}
