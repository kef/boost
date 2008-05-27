package au.net.netstorm.boost.nursery.eight.legged.spider.rules.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

// FIX 2394 drive up rules state
public final class DefaultRulesAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Rules subject;
    KeyedRule keyedMock;

    public void setUpFixtures() {
        subject = new DefaultRules();
    }

    public void testAddKeyedRule() {
        try {
            subject.add(keyedMock);
            fail();
        } catch (UnsupportedOperationException expected) {}
    }
}
