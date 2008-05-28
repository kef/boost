package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultInjectionTypeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionType subject;

    public void setUpFixtures() {
        // FIX 2394 implement me
        subject = new DefaultInjectionType();
    }

    public void testInjectionType() {
        // FIX 2394 colour me in
    }

    public void testInjectionTypeFailure() {
        // FIX 2394 colour me in
    }
}
