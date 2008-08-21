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
import au.net.netstorm.boost.sniper.spider.DefaultTestSpiderBuilder;
import au.net.netstorm.boost.sniper.spider.TestSpiderBuilder;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.registry.Registry;

public class LifecycleTestCase extends IoCTestCase {
    public static final Object VOID = MockExpectations.VOID;
    private TestLifecycleRunner runner;
    public Expectations expect;
    // FIX 2394 why is this public?
    public Spider spider;

    // FIX 2394 FREEZE moving along... do not touch this.
    // FIX 2394 push into IoCTestCase
    private void ioc() {
        // SUGGEST: Ugly little beast.
        spider = getSpider();
        // FIX 2394 split into IoC setup and sniper setup
        setupRegistry();
        bootstrap();
        MockSupport mocks = spider.resolve(MockSupport.class);
        MockExpectations mockExpectations = spider.nu(MockExpectations.class, mocks);
        NuImplExpectations nuImplExpectations = spider.nu(NuImplExpectations.class, mockExpectations);
        NuExpectations nuExpectations = spider.nu(NuExpectations.class, mockExpectations);
        expect = spider.nu(Expectations.class, mockExpectations, nuImplExpectations, nuExpectations);
        runner = spider.resolve(TestLifecycleRunner.class);
    }

    public final void runBare() throws Throwable {
        // FIX BREADCRUMB 2394 pushing around some code to be ready for a switch over.
        // FIX 2394 split out into a root and delegate for ioc.
        ioc();
        runner.run();
    }

    // SUGGEST (Dec 4, 2007): Put public methods on interface?
    public Spider getSpider() {
        // FIX 2394 Switch this code in and see what barfs. Push hard to get new spiderage happening.
//        SpiderEgg egg = new DefaultSpiderEgg();
//        return egg.hatch();
        TestSpiderBuilder builder = new DefaultTestSpiderBuilder();
        return builder.build();
    }

    public void framework(Registry registry) {
        registry.single(TestLifecycleBlocks.class, BoostTestLifecycleBlocks.class);
        registry.single(ProvidesData.class, BoostDataProviders.class);
    }

    private void setupRegistry() {
        Registry registry = spider.resolve(Registry.class);
        registry.instance(Test.class, this);
        framework(registry);
    }

    private void bootstrap() {
        TestLifecycleBootstrap bootstrap = spider.resolve(TestLifecycleBootstrap.class);
        bootstrap.bootstrap();
    }
}
