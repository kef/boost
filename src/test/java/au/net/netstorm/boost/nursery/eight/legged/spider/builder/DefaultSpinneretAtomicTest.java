package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultSpinneretAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Spinneret subject;

    public void setUpFixtures() {
        subject = new DefaultSpinneret();
    }

    // FIX 2394 has some tight coupling with rules and factories
    public void testSpin() {
        subject.spin();
        // FIX 2394 colour me in
    }
}
