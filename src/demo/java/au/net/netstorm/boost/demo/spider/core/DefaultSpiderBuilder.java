package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.provider.Nu;
import au.net.netstorm.boost.spider.flavour.DefaultInterfaceMap;
import au.net.netstorm.boost.spider.flavour.InterfaceMap;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.newer.assembly.DefaultNewerAssembler;
import au.net.netstorm.boost.spider.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.registry.BlueprintedFactory;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.BlueprintsRead;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.DefaultFactories;
import au.net.netstorm.boost.spider.registry.DefaultFactoryBuilder;
import au.net.netstorm.boost.spider.registry.DefaultInstances;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.FactoryBuilder;
import au.net.netstorm.boost.spider.registry.ImplicitFactory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.NewerFactory;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.util.impl.ImplMaster;

// FIX 2215 Sort out builder/assembler discrepancy.
// FIX 2215 Refactor.  Too messy.

// FIX 1914 Move these out of here.  Web, LazyGreens, SpiderBuilder.

// FIX 2215 Why is this class in "demo"?  It's some sort of wirer?!

public final class DefaultSpiderBuilder implements SpiderBuilder {
    private final SpiderAssembler assembler = new DefaultSpiderAssembler();

    public Spider build(ImplMaster impler) {
        Spider spider = doBuild(impler);
        preregister(spider, impler);
        return spider;
    }

    private Spider doBuild(ImplMaster impler) {
        Blueprints blueprints = nuBlueprints();
        Factories factories = factories(blueprints, impler);
        Instances instances = nuInstances();
        return buildSpider(instances, factories, blueprints);
    }

    private void preregister(Spider spider, ImplMaster impler) {
        Registry registry = (Registry) spider.resolve(Registry.class);
        registry.instance(ImplMaster.class, impler);
    }

    private Factories factories(Blueprints blueprints, ImplMaster impler) {
        Factories factories = nuFactories();
        // FIX BREADCRUMB 2215 How do we enforce ordering?  High cost factories should be last?
        implicit(factories, impler);
        explicit(factories, blueprints);
        newer(factories);
        return factories;
    }

    private void implicit(Factories factories, ImplMaster impler) {
        ImplicitFactory factory = new ImplicitFactory(impler);
        factories.add(factory);
    }

    private void explicit(Factories factories, BlueprintsRead blueprints) {
        Factory factory = new BlueprintedFactory(blueprints);
        factories.add(factory);
    }

    private void newer(Factories factories) {
        NewerAssembler newer = new DefaultNewerAssembler();
        Factory factory = new NewerFactory(newer);
        factories.add(factory);
    }

    private Spider buildSpider(Instances instances, Factories factories, Blueprints blueprints) {
        Spider spider = assembler.assemble(instances, factories);
        preregister(spider, instances, blueprints, factories);
        return spider;
    }

    private void preregister(Spider spider, Instances instances, Blueprints blueprints, Factories factories) {
        FactoryBuilder builder = new DefaultFactoryBuilder(spider);
        Registry registry = new DefaultRegistry(blueprints, instances, factories, builder);
        registry.instance(Registry.class, registry);
        registry.instance(Resolver.class, spider);
        registry.instance(Injector.class, spider);
        registry.instance(Nu.class, spider);
    }

    private Factories nuFactories() {
        return new DefaultFactories();
    }

    private Instances nuInstances() {
        InterfaceMap map = nuMap();
        return new DefaultInstances(map);
    }

    private Blueprints nuBlueprints() {
        InterfaceMap map = nuMap();
        return new DefaultBlueprints(map);
    }

    private InterfaceMap nuMap() {
        return new DefaultInterfaceMap();
    }
}
