package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.test.automock.DefaultMockExpectations;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.test.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.test.lifecycle.TestLifecycleRunner;
import au.net.netstorm.boost.test.specific.BoostDataProviders;
import au.net.netstorm.boost.test.specific.ProvidesData;
import au.net.netstorm.boost.util.impl.DefaultImplMapper;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.impl.ImplMapper;
import au.net.netstorm.boost.util.impl.ImplMaster;

public abstract class LifecycleTestCase extends CleanTestCase {
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
        SpiderBuilder builder = new DefaultSpiderBuilder();
        ImplMaster master = getMapper();
        return builder.build(master);
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

    private ImplMaster getMapper() {
        ImplMapper a1 = new DefaultImplMapper("Default");
        ImplMapper[] mappers = {a1};
        return new DefaultImplMaster(mappers);
    }
}
