package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

// FIX BREADCRUMB 73022 The DefaultSpiderBuilder's location requires this test to be in 'demo' tree.
public final class LogFlavourTest extends InteractionTestCase implements HasFixtures {
    SpiderBuilder builder = new DefaultSpiderBuilder();
    SensitiveOp subject;
    Spider spider;
    LogUtil logUtilMock;

    public void setUpFixtures() {
        spider = builder.build();
        Registry registry = (Registry) spider.resolve(Registry.class);
        registry.instance(LogUtil.class, logUtilMock);
//        registry.multiple(Log.class,  DefaultLog.class);
        subject = (SensitiveOp) spider.resolve(SensitiveOp.class);
    }

    public void testPerform() {
        // FIX BREADCRUMB 73022 Reinstate this.
//        expect.oneCall(logUtilMock, VOID, "info", DefaultSensitiveOp.class, "Sensitive op performed.");
//        subject.perform();
    }
}
