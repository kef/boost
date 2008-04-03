package au.net.netstorm.boost.gunge.core;

import au.net.netstorm.boost.gunge.atom.AtomTestChecker;
import au.net.netstorm.boost.gunge.atom.DataAtomTestChecker;
import au.net.netstorm.boost.gunge.automock.DefaultTestFieldInjector;
import au.net.netstorm.boost.gunge.automock.MockSupport;
import au.net.netstorm.boost.gunge.automock.TestFieldInjector;
import au.net.netstorm.boost.gunge.marker.ProvidesData;
import au.net.netstorm.boost.gunge.random.RandomProviderAssembler;
import au.net.netstorm.boost.gunge.specific.DataProviders;
import au.net.netstorm.boost.gunge.specific.EnumProvider;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.spider.register.Registry;

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
