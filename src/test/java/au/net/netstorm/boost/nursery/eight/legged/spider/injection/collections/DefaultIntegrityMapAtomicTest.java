package au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultIntegrityMapAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    IntegrityMap subject;

    public void setUpFixtures() {
        // FIX 2394 inject delegate map
    }

    // FIX 2394 implement get existing test
    public void testGet() {

    }

    // FIX 2394 implement create non-existing test
    public void testCreate() {
        
    }
}
