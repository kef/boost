package au.net.netstorm.boost.demo.nuspider.test;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpinneret;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.Spinneret;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
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
        Spinneret spinneret = new DefaultSpinneret();
        SpiderEgg egg = spinneret.spin(NuSpiderDemooooConfig.class);
        Web web = egg.spin();
        Binder binder = web.binder();
        binder.bind(Test.class).to(test);
        return egg.hatch();
    }


}
