package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.test.automock.DefaultMockExpectations;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.test.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.test.lifecycle.TestLifecycleRunner;
import au.net.netstorm.boost.test.marker.ProvidesData;
import au.net.netstorm.boost.test.specific.BoostDataProviders;
import au.net.netstorm.boost.test.spider.DefaultTestSpiderBuilder;
import au.net.netstorm.boost.test.spider.TestSpiderBuilder;

public class LifecycleTestCase extends CleanTestCase {
    public static final Object VOID = MockExpectations.VOID;
    private final TestLifecycleRunner runner;
    public final MockExpectations expect;
    private final MockSupport mocks;
    public final Spider spider;

    protected LifecycleTestCase() {
        spider = getSpider();
        setupRegistry();
        bootstrap();
        mocks = spider.resolve(MockSupport.class);
        expect = spider.nu(DefaultMockExpectations.class, mocks);
        runner = spider.resolve(TestLifecycleRunner.class);
    }

    public final void runBare() throws Throwable {
        runner.run();
    }

    public Spider getSpider() {
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
