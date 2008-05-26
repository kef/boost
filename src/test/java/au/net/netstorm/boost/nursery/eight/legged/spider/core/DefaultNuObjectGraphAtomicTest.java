package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultNuObjectGraphAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private NuObjectGraph subject;

    public void setUpFixtures() {
        subject = new DefaultNuObjectGraph();
    }

    public void testNu() {
        try {
            subject.nu(Ball.class);
            fail();
        } catch (UnsupportedOperationException expected) {}
    }
}
