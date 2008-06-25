package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.eight.legged.spider.collections.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.collections.Creator;

public final class DefaultBindingsAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Bindings subject;
    FieldTestUtil fielder;
    IntegrityMap bindingsMock;
    Creator creatorMock;

    public void setUpFixtures() {
        subject = new DefaultBindings();
        fielder.setInstance(subject, "bindings", bindingsMock);
        fielder.setInstance(subject, "creator", creatorMock);
    }

    public void testAdd() {
        // FIX 2394 test me
    }

    public void testLookup() {
        // FIX 2394 test me
    }
}
