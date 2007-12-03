package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.test.automock.DefaultMockExpectations;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.exception.DefaultThrowableSupport;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.test.lifecycle.TestLifecycleRunner;
import au.net.netstorm.boost.test.specific.BoostDataProviders;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.ProvidesData;
import au.net.netstorm.boost.util.impl.DefaultImplMapper;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.impl.ImplMapper;
import au.net.netstorm.boost.util.impl.ImplMaster;

public abstract class LifecycleTestCase extends CleanTestCase implements LifecycleTest, ProvidesData {
    public static final Object VOID = MockExpectations.VOID;
    public final Spider spider = getSpider();
    private final MockSupport mocks = spider.resolve(MockSupport.class);
    public final MockExpectations expect = spider.nu(DefaultMockExpectations.class, mocks);
    private final TestLifecycleRunner runner = spider.resolve(TestLifecycleRunner.class);

    public final void runBare() throws Throwable {
        registerTest();
        bootstrap();
        runner.run(this);
    }

    public Class<? extends TestLifecycleBlocks> lifecycle() {
        return BoostTestLifecycleBlocks.class;
    }

    public Spider getSpider() {
        SpiderBuilder builder = new DefaultSpiderBuilder();
        ImplMaster master = getMapper();
        return builder.build(master);
    }

    // FIX (Dec 3, 2007) IOC 85875 What this is used for?
    public ThrowableSupport throwableSupport() {
        return new DefaultThrowableSupport();
    }

    public void register(DataProviders dataProviders, Provider random) {
        ProvidesData baseProviders = new BoostDataProviders();
        baseProviders.register(dataProviders, random);
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

    private void registerTest() {
        Registry registry = spider.resolve(Registry.class);
        registry.instance(Test.class, this);
    }
}
