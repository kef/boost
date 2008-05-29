package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class DefaultRuleBuilderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private RuleBuilder subject;
    Factory factoryMock;

    public void setUpFixtures() {
        subject = new DefaultRuleBuilder();
    }

    public void testBuild() {
        subject.setScope(TreeHolder.class, "tree");
        subject.setIsSingleton(true);
        subject.setMapping(factoryMock);
    }
}
