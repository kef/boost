package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.KeyedRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.WildcardRules;

// FIX 2394 build up test
public final class DefaultRuleResolverAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private RuleResolver subject;
    KeyedRules keyedRulesMock;
    WildcardRules wildcardRulesMocks;

    public void setUpFixtures() {
        subject = new DefaultRuleResolver(keyedRulesMock, wildcardRulesMocks);
    }

    public void testResolveKeyed() {

    }

    public void testResolvedWildcarded() {

    }

    public void testResolvedWildcardFallback() {

    }

    public void testUnresolvable() {

    }
}
