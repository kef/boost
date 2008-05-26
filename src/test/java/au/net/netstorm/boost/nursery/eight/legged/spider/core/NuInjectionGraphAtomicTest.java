package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class NuInjectionGraphAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private NuInjectionGraph subject;

    // FIX BREADCRUMB 2394 implementing me
    public void setUpFixtures() {
//        subject = new DefaultInjectionGraph();
    }

    public void testNu() {
//        subject.nu(Ball.class);
    }
}
