package au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultRulesAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Rules subject;
    Rule ruleMock;

    public void setUpFixtures() {
        subject = new DefaultRules();
    }

    public void testAdd() {
        // FIX 2394 implement me
        try {
            subject.add(ruleMock);
            fail();
        } catch (UnsupportedOperationException expected) {}
    }
}
