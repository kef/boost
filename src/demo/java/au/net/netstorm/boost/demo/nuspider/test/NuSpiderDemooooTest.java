package au.net.netstorm.boost.demo.nuspider.test;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
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
        Spider spider = egg.hatch(NuSpiderDemooooConfig.class);
        Binder binder = spider.resolve(Binder.class);
        binder.bind(Test.class).to(test);
        return spider;
    }


}
