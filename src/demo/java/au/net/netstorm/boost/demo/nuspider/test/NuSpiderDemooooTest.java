package au.net.netstorm.boost.demo.nuspider.test;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.sniper.core.CleanTestCase;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleRunner;
import au.net.netstorm.boost.spider.core.Spider;

public abstract class NuSpiderDemooooTest extends CleanTestCase {
    private final TestLifecycleRunner runner;
    public final Spider spider;

    public NuSpiderDemooooTest() {
        spider = bootstrap(this);
        runner = spider.resolve(TestLifecycleRunner.class);
    }

    public void runBare() throws Throwable {
        runner.run();
    }

    private static Spider bootstrap(Test test) {
        SpiderEgg egg = new DefaultSpiderEgg();
        NuSpiderDemooooWebConfig config = new NuSpiderDemooooWebConfig(test);
        return egg.hatch(config);
    }
}
