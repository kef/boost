package au.net.netstorm.boost.sniper.core;

import au.net.netstorm.boost.sniper.automock.MockExpectations;
import au.net.netstorm.boost.sniper.automock.MockSupport;
import au.net.netstorm.boost.sniper.bootstrap.TestLifecycleBootstrap;
import au.net.netstorm.boost.sniper.expect.Expectations;
import au.net.netstorm.boost.sniper.expect.NuExpectations;
import au.net.netstorm.boost.sniper.expect.NuImplExpectations;
import au.net.netstorm.boost.sniper.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleRunner;
import au.net.netstorm.boost.sniper.marker.ProvidesData;
import au.net.netstorm.boost.sniper.specific.BoostDataProviders;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.registry.Registry;

public class LifecycleTestCase extends IoCTestCase {
    public static final Object VOID = MockExpectations.VOID;
    private TestLifecycleRunner runner;
    public Expectations expect;

    public void runBareWithIoC(Spider spider) throws Throwable {
        // FIX BREADCRUMB 2394 pushing around some code to be ready for a switch over.
        // FIX 2394 split out into a root and delegate for ioc.
        bootstrapa(spider);
        runner.run();
    }

    // SUGGEST: Ugly little beast.
    // FIX 2394 maybe try calling injector.inject(this) and do this base on spider config.
    private void bootstrapa(Spider spider) {
        register();
        bootstrap();
        MockSupport mocks = spider.resolve(MockSupport.class);
        MockExpectations mockExpectations = spider.nu(MockExpectations.class, mocks);
        NuImplExpectations nuImplExpectations = spider.nu(NuImplExpectations.class, mockExpectations);
        NuExpectations nuExpectations = spider.nu(NuExpectations.class, mockExpectations);
        expect = spider.nu(Expectations.class, mockExpectations, nuImplExpectations, nuExpectations);
        runner = spider.resolve(TestLifecycleRunner.class);
    }


    // FIX 2394 switch over to binder.
    private void register() {
        Registry registry = spider.resolve(Registry.class);
        registry.instance(Test.class, this);
        // FIX 2394 kill this.
        framework(registry);
    }

    // FIX 2394 this should dissappear with new spider.
    // FIX 2394 each sub class can provide its own SpiderConfig to hatch that does this.
    public void framework(Registry registry) {
        // FIX 2394 SWITCHME. remove this registration.
        registry.single(TestLifecycleBlocks.class, BoostTestLifecycleBlocks.class);
        registry.single(ProvidesData.class, BoostDataProviders.class);
    }

    // FIX 2394 can this actually be a step in the lifecycle?
    private void bootstrap() {
        TestLifecycleBootstrap bootstrap = spider.resolve(TestLifecycleBootstrap.class);
        bootstrap.bootstrap();
    }
}
