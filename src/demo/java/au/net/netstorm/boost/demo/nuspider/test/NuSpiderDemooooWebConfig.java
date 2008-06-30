package au.net.netstorm.boost.demo.nuspider.test;

import au.net.netstorm.boost.gunge.provider.Random;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.ScalpelStaticFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.atom.DataAtomTestChecker;
import au.net.netstorm.boost.sniper.automock.DefaultMockSupport;
import au.net.netstorm.boost.sniper.automock.DefaultTestFieldInjector;
import au.net.netstorm.boost.sniper.automock.MockSupport;
import au.net.netstorm.boost.sniper.automock.TestFieldInjector;
import au.net.netstorm.boost.sniper.core.Test;
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
import au.net.netstorm.boost.scalpel.engine.EdgePackage;
import au.net.netstorm.boost.demo.edge.DemoEdgePackage;

// FIX 2394 smelly, better idea would be to just have a no-arg configure method, allow binder/web to be injected
public final class NuSpiderDemooooWebConfig implements WebConfig, RuleConfig {
    private final Test test;

    public NuSpiderDemooooWebConfig(Test test) {
        this.test = test;
    }

    public void apply(Web web) {
        web.register(ScalpelStaticFactory.class);
        web.register(this);
    }
    
    public void apply(Binder binder) {
        binder.bind(EdgePackage.class).to(DemoEdgePackage.class);
        binder.bind(TestLifecycleBlocks.class).to(BoostTestLifecycleBlocks.class);
        binder.bind(Test.class).to(test);
        bindRandom(binder);
    }

    private void bindRandom(Binder binder) {
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
