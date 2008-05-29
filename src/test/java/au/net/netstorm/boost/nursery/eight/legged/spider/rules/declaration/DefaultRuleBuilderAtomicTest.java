package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.Matcher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultRuleBuilderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private RuleBuilder subject;
    Factory factoryMock;
    InjectionType typeMock;
    Matcher matcherMock;

    public void setUpFixtures() {
        subject = new DefaultRuleBuilder(typeMock);
    }

    public void testBuild() {
        subject.setScope(matcherMock);
        subject.setIsSingleton(true);
        subject.setMapping(factoryMock);
        checkBuild();
    }

    private void checkBuild() {
        KeyedRule result = subject.build();
        InjectionType actual = result.key();
        assertSame(typeMock, actual);
    }
}
