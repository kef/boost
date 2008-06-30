package au.net.netstorm.boost.demo.nuspider.test;

import au.net.netstorm.boost.demo.edge.DemoEdgePackage;
import au.net.netstorm.boost.gunge.provider.Random;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.ScalpelFactory;
import au.net.netstorm.boost.scalpel.engine.EdgePackage;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.atom.DataAtomTestChecker;
import au.net.netstorm.boost.sniper.automock.DefaultMockSupport;
import au.net.netstorm.boost.sniper.automock.DefaultTestFieldInjector;
import au.net.netstorm.boost.sniper.automock.MockSupport;
import au.net.netstorm.boost.sniper.automock.TestFieldInjector;
import au.net.netstorm.boost.sniper.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.sniper.marker.ProvidesData;
import au.net.netstorm.boost.sniper.random.DefaultRandomProviderAssembler;
import au.net.netstorm.boost.sniper.random.RandomProviderAssembler;
import au.net.netstorm.boost.sniper.specific.BoostDataProviders;
import au.net.netstorm.boost.sniper.specific.DataProviders;
import au.net.netstorm.boost.sniper.specific.DefaultDataProviders;
import au.net.netstorm.boost.sniper.specific.DefaultEnumProvider;
import au.net.netstorm.boost.sniper.specific.EnumProvider;

// FIX 2394 split, need to come up with a pattern for making sure these guys do not always suck
public final class NuSpiderDemooooConfig implements SpiderConfig {
    Web web;
    Binder binder;

    public void configure() {
        web.register(ScalpelFactory.class);
        binder.bind(EdgePackage.class).to(DemoEdgePackage.class);
        binder.bind(TestLifecycleBlocks.class).to(BoostTestLifecycleBlocks.class);
        bindTestHelpers();
    }

    private void bindTestHelpers() {
        DataProviders data = new DefaultDataProviders();
        EnumProvider enums = new DefaultEnumProvider();
        MockSupport mocks = new DefaultMockSupport();
        Random random = buildRandom(data, enums, mocks);
        binder.bind(Random.class).to(random);
        bindChecker(binder, random);
        bindTestInjector(binder, mocks, random);
        bindDataProvider(binder, data, enums, random);
    }

    private void bindTestInjector(Binder binder, MockSupport mocks, Random random) {
        TestFieldInjector injector = new DefaultTestFieldInjector(mocks, random);
        binder.bind(TestFieldInjector.class).to(injector);
    }

    private void bindChecker(Binder binder, Random random) {
        AtomTestChecker checker = new DataAtomTestChecker(random);
        binder.bind(AtomTestChecker.class).to(checker);
    }

    private void bindDataProvider(Binder binder, DataProviders data, EnumProvider enums, Random random) {
        BoostDataProviders providers = new BoostDataProviders();
        providers.register(data, enums, random);
        binder.bind(ProvidesData.class).to(providers);
    }

    private Random buildRandom(DataProviders data, EnumProvider enums, MockSupport mocks) {
        RandomProviderAssembler assembler = new DefaultRandomProviderAssembler();
        return assembler.everything(data, enums, mocks);
    }
}
