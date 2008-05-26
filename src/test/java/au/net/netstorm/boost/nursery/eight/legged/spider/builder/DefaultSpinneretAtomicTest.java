package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;

public final class DefaultSpinneretAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Spinneret subject;

    public void setUpFixtures() {
        subject = new DefaultSpinneret();
    }

    // FIX BREADCRUMB 2394 driving up builder
    public void testSpin() {
        Web web = subject.spin();
        // FIX 2394 is it a valid web
    }
}
