package au.net.netstorm.boost.sniper.bootstrap;

import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.gunge.provider.Random;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.atom.DataAtomTestChecker;
import au.net.netstorm.boost.sniper.automock.DefaultTestFieldInjector;
import au.net.netstorm.boost.sniper.automock.MockSupport;
import au.net.netstorm.boost.sniper.automock.TestFieldInjector;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.marker.ProvidesData;
import au.net.netstorm.boost.sniper.random.RandomProviderAssembler;
import au.net.netstorm.boost.sniper.specific.DataProviders;
import au.net.netstorm.boost.sniper.specific.EnumProvider;
import au.net.netstorm.boost.spider.registry.Registry;

public class DefaultTestLifecycleBootstrap implements TestLifecycleBootstrap {
    RandomProviderAssembler assembler;
    ProvidesData registerer;
    DataProviders data;
    EnumProvider enums;
    Registry registry;
    MockSupport mocks;
    Test test;

    public void bootstrap() {
        Random random = assembler.everything(data, enums, mocks);
        registry.instance(Random.class, random);
        registerProviders(random);
        registerAtomChecker(registry, random);
        registerFieldInjector(registry, random);
    }

    private void registerProviders(Random random) {
        registerer.register(data, enums, random);
    }

    private void registerAtomChecker(Registry registry, Provider random) {
        AtomTestChecker atomChecker = new DataAtomTestChecker(random);
        registry.instance(AtomTestChecker.class, atomChecker);
    }

    private void registerFieldInjector(Registry registry, Provider random) {
        TestFieldInjector fieldInjector = new DefaultTestFieldInjector(mocks, random);
        registry.instance(TestFieldInjector.class, fieldInjector);
    }
}
