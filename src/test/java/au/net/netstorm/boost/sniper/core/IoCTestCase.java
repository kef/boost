package au.net.netstorm.boost.sniper.core;

import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.sniper.spider.TestSpiderBuilder;
import au.net.netstorm.boost.sniper.spider.DefaultTestSpiderBuilder;

// FIX 2394 temporary step, i think the ioc should not be in the test class hierachy, rather in the lifecycle somewhere.
// FIX 2394 seperate out IoC required for framework vs IoC required for code under test.
public abstract class IoCTestCase extends CleanTestCase {
    // FIX 2394 Why is this public? or even a field now? Check fist and delete.
    public Spider spider;

    public final void runBare() throws Throwable {
        spider = getSpider();
        runBareWithIoC(spider);
    }

    public abstract void runBareWithIoC(Spider spider) throws Throwable;

        // SUGGEST (Dec 4, 2007): Put public methods on interface?
    // FIX 2394 name (if this guy lives on). nuSpider. getSpider is decieving.
    public Spider getSpider() {
        // FIX 2394 Switch this code in and see what barfs. Push hard to get new spiderage happening.
//        SpiderEgg egg = new DefaultSpiderEgg();
//        return egg.hatch();
        TestSpiderBuilder builder = new DefaultTestSpiderBuilder();
        return builder.build();
    }

}
