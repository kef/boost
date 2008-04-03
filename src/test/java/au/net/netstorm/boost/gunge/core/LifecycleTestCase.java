package au.net.netstorm.boost.gunge.core;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.gunge.automock.DefaultMockExpectations;
import au.net.netstorm.boost.gunge.automock.MockExpectations;
import au.net.netstorm.boost.gunge.automock.MockSupport;
import au.net.netstorm.boost.gunge.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.gunge.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.gunge.lifecycle.TestLifecycleRunner;
import au.net.netstorm.boost.gunge.marker.ProvidesData;
import au.net.netstorm.boost.gunge.specific.BoostDataProviders;
import au.net.netstorm.boost.gunge.spider.DefaultTestSpiderBuilder;
import au.net.netstorm.boost.gunge.spider.TestSpiderBuilder;
import au.net.netstorm.boost.spider.register.Registry;

public class LifecycleTestCase extends CleanTestCase {
    public static final Object VOID = MockExpectations.VOID;
    private final TestLifecycleRunner runner;
    public final Expectations expect;
    public final Spider spider;

    protected LifecycleTestCase() {
        spider = getSpider();
        setupRegistry();
        bootstrap();
        MockSupport mocks = spider.resolve(MockSupport.class);
        MockExpectations mockExpectations = spider.nu(DefaultMockExpectations.class, mocks);
        NuExpectations nuExpectations = spider.nu(DefaultNuExpectations.class, mockExpectations);
        TypesExpectations typesExpectations = spider.nu(DefaultTypesExpectations.class, mockExpectations);
        expect = spider.nu(DefaultExpectations.class, mockExpectations, nuExpectations, typesExpectations);
        runner = spider.resolve(TestLifecycleRunner.class);
    }

    public final void runBare() throws Throwable {
        runner.run();
    }

    // SUGGEST (Dec 4, 2007): Put public methods on interface?
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
