package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.flavour.DefaultInterfaceMap;
import au.net.netstorm.boost.spider.flavour.InterfaceMap;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.DefaultFactories;
import au.net.netstorm.boost.spider.registry.DefaultInstances;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Greenprints;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.LayeredGreenprints;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.util.impl.BasicImplMapper;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.impl.ImplMapper;
import au.net.netstorm.boost.util.impl.ImplMaster;

// FIX 1914 Move these out of here.  Web, LazyGreens, SpiderBuilder.
public final class DefaultSpiderBuilder implements SpiderBuilder {
    private final SpiderAssembler assembler = new DefaultSpiderAssembler();

    public Spider build() {
        ImplMapper[] mappers = mappers();
        return build(mappers);
    }

    public Spider build(ImplMapper[] implMappers) {
        Greenprints lazy = greenprints(implMappers);
        Blueprints explicit = nuBlueprints();
        Greenprints layered = nuGreenprints(explicit, lazy);
        Instances instances = nuInstances();
        Factories factories = nuFactories();
        return buildSpider(layered, instances, factories, explicit);
    }

    private Greenprints nuGreenprints(Blueprints explicit, Greenprints lazy) {
        Greenprints[] layers = {explicit, lazy};
        return new LayeredGreenprints(layers);
    }

    private Spider buildSpider(Greenprints layered, Instances instances, Factories factories, Blueprints explicit) {
        Spider spider = assembler.assemble(layered, instances, factories);
        preregister(explicit, instances, factories, spider);
        return spider;
    }

    private void preregister(Blueprints explicit, Instances instances, Factories factories, Spider spider) {
        Registry registry = new DefaultRegistry(spider, explicit, instances, factories);
        registry.instance(Registry.class, registry);
        registry.instance(Resolver.class, spider);
        registry.instance(Injector.class, spider);
    }

    private Factories nuFactories() {
        return new DefaultFactories();
    }

    private Greenprints greenprints(ImplMapper[] implMappers) {
        ImplMaster impler = new DefaultImplMaster(implMappers);
        return new LazyGreenprints(impler);
    }

    private ImplMapper[] mappers() {
        ImplMapper mapper = new BasicImplMapper();
        return new ImplMapper[]{mapper};
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
