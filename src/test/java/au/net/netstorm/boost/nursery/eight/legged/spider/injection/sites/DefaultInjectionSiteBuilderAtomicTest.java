package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultInjectionSiteBuilderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionSiteBuilder subject;

    public void setUpFixtures() {
        subject = new DefaultInjectionSiteBuilder();
    }

    public void testBuildField() {
        // FIX 2394 drive me up
    }

    public void testBuildConstructor() {
        // FIX 2394 drive me up
    }
}
