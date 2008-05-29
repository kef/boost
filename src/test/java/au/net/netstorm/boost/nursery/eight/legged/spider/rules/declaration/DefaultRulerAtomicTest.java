package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;

public final class DefaultRulerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Ruler subject;
    Rules rules;

    public void setUpFixtures() {
        subject = new DefaultRuler(rules);
    }

    public void testMapClass() {
        // FIX 2394 colour me in
    }

    public void testMapInjectionType() {
        // FIX 2394 colour me in
    }
}
