package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.flavour.DefaultInterfaceMap;
import au.net.netstorm.boost.spider.flavour.InterfaceMap;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.DefaultFactories;
import au.net.netstorm.boost.spider.registry.DefaultFactoryBuilder;
import au.net.netstorm.boost.spider.registry.DefaultInstances;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.FactoryBuilder;
import au.net.netstorm.boost.spider.registry.Greenprints;
import au.net.netstorm.boost.spider.registry.GreenprintsFactory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.util.impl.BasicImplMapper;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.impl.ImplMapper;
import au.net.netstorm.boost.util.impl.ImplMaster;

// FIX 2215 Sort out builder/assembler discrepancy.
// FIX 2215 Refactor.  Too messy.

// FIX 1914 Move these out of here.  Web, LazyGreens, SpiderBuilder.
public final class DefaultSpiderBuilder implements SpiderBuilder {
    private final SpiderAssembler assembler = new DefaultSpiderAssembler();

    public Spider build() {
        ImplMapper[] mappers = mappers();
        return build(mappers);
    }

    public Spider build(ImplMapper[] implMappers) {
        Greenprints implicit = implicit(implMappers);
        Blueprints explicit = explicit();
        Instances instances = nuInstances();
        Factories factories = nuFactories();
        greenprints(factories, instances, explicit, implicit);
        return buildSpider(instances, factories, explicit);
    }

    // FIX BREADCRUMB 2215 Keep going.
    private void greenprints(Factories factories, Instances instances, Greenprints explicit, Greenprints implicit) {
        greenprint(factories, instances, implicit);
        greenprint(factories, instances, explicit);
    }

    private void greenprint(Factories factories, Instances instances, Greenprints greenprints) {
        Factory factory = new GreenprintsFactory(greenprints, instances);
        factories.add(factory);
    }

    private Spider buildSpider(Instances instances, Factories factories, Blueprints explicit) {
        Spider spider = assembler.assemble(instances, factories);
        preregister(explicit, instances, factories, spider);
        return spider;
    }

    private void preregister(Blueprints explicit, Instances instances, Factories factories, Spider spider) {
        FactoryBuilder builder = new DefaultFactoryBuilder(spider);
        Registry registry = new DefaultRegistry(explicit, instances, factories, builder);
        registry.instance(Registry.class, registry);
        registry.instance(Resolver.class, spider);
        registry.instance(Injector.class, spider);
    }

    private Factories nuFactories() {
        return new DefaultFactories();
    }

    private Greenprints implicit(ImplMapper[] implMappers) {
        ImplMaster impler = new DefaultImplMaster(implMappers);
        return new ImplicitGreenprints(impler);
    }

    private ImplMapper[] mappers() {
        ImplMapper mapper = new BasicImplMapper();
        return new ImplMapper[]{mapper};
    }

    private Instances nuInstances() {
        InterfaceMap map = nuMap();
        return new DefaultInstances(map);
    }

    private Blueprints explicit() {
        InterfaceMap map = nuMap();
        return new DefaultBlueprints(map);
    }

    private InterfaceMap nuMap() {
        return new DefaultInterfaceMap();
    }
}
