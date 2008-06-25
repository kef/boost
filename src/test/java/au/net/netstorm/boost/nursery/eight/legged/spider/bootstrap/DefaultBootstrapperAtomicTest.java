package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;

public final class DefaultBootstrapperAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Bootstrapper subject;
    InjectionWeb injectionsMock;
    Web webMock;

    public void setUpFixtures() {
        subject = new DefaultBootstrapper(webMock, injectionsMock);
    }

    public void test() {
        // FIX 2394 test this, probably requires a checker for WebConfig and RuleConfig will come in handy later
    }
}
