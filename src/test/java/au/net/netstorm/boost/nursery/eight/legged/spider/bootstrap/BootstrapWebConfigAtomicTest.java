package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.BlueprintedFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ImpliedFactory;

public final class BootstrapWebConfigAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private WebConfig subject;
    Web webMock;

    public void setUpFixtures() {
        subject = new BootstrapWebConfig();
    }

    public void testApply() {
        expect.oneCall(webMock, VOID, "register", BlueprintedFactory.class);
        expect.oneCall(webMock, VOID, "register", ImpliedFactory.class);
        expect.oneCall(webMock, VOID, "register", BootstrapFactory.class);
        subject.apply(webMock);
    }
}
