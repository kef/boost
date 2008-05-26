package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultNuInjectionGraphAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private NuInjectionGraph subject;

    // FIX BREADCRUMB 2394 implementing me
    public void setUpFixtures() {
        subject = new DefaultNuInjectionGraph();
    }

    public void testNu() {
        // FIX 2394 colour me in
        try {
            InjectionGraph<Ball> graph = subject.nu(Ball.class);
            fail();
        } catch(UnsupportedOperationException expected) {}
    }
}
