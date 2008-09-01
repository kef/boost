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
        bootstrapa(spider);
        runner.run();
    }

    // SUGGEST: Ugly little beast.
    // FIX 2394 maybe try calling injector.inject(this) and do this base on spider config, or make part of lifecycle.    
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
        // FIX 2394 Kill this, rely on SpiderConfig.
        framework(registry);
    }

    // FIX 2394 This can dissappear with new spider. Tt is redundant, see SniperSpiderConfig.
    // FIX 2394 Each sub TestCase class can provide its own SpiderConfig that does this.
    public void framework(Registry registry) {
        registry.single(TestLifecycleBlocks.class, BoostTestLifecycleBlocks.class);
        registry.single(ProvidesData.class, BoostDataProviders.class);
    }

    // FIX 2394 Can this actually be a step in the lifecycle?
    private void bootstrap() {
        TestLifecycleBootstrap bootstrap = spider.resolve(TestLifecycleBootstrap.class);
        bootstrap.bootstrap();
    }
}
