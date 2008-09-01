package au.net.netstorm.boost.sniper.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.ioc.BoostSpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.test.RequiresNewSpider;
import au.net.netstorm.boost.sniper.spider.DefaultTestSpiderBuilder;
import au.net.netstorm.boost.sniper.spider.TestSpiderBuilder;
import au.net.netstorm.boost.spider.core.Spider;

// FIX 2394 temporary step, i think the ioc should not be in the test class hierachy, rather in the lifecycle somewhere.
public abstract class IoCTestCase extends CleanTestCase {
    // FIX 2394 Why is this public? or even a field now? Check fist and delete.
    public Spider spider;

    public final void runBare() throws Throwable {
        spider = getSpider();
        runBareWithIoC(spider);
    }

    public abstract void runBareWithIoC(Spider spider) throws Throwable;

    // SUGGEST (Dec 4, 2007): Put public methods on interface?
    // FIX 2394 when moving to new spider kill this. force sub classes to specify spider configs to hatch.
    // FIX 2394 name (if this guy lives on). nuSpider. getSpider is decieving.
    public Spider getSpider() {
        // FIX 2394 SWITCHME.
        return this instanceof RequiresNewSpider ? nu() : old();
    }

    // FIX 2394 NUSPIDER ONLY.
    public Class[] config() {
        return new Class[] {BoostSpiderConfig.class, SniperSpiderConfig.class};
    }

    // FIX 2394 NUSPIDER ONLY.
    private Spider nu() {
        SpiderEgg egg = new DefaultSpiderEgg();
        Class[] configs = config();
        return egg.hatch(configs);
    }

    // FIX 2394 OLDSPIDER ONLY.
    private Spider old() {
        TestSpiderBuilder builder = new DefaultTestSpiderBuilder();
        return builder.build();
    }
}
