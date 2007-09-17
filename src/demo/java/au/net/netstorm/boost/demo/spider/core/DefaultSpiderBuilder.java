package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMap;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMapEngine;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.flavour.FlavouredMapEngine;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.DefaultInstances;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.Greenprints;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.LayeredGreenprints;
import au.net.netstorm.boost.spider.registry.Redprints;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.util.impl.BasicImplMapper;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.impl.ImplMapper;
import au.net.netstorm.boost.util.impl.ImplMaster;

// SUGGEST: More work needed on this interface.

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
        // FIX 1887 Create and incorporate "newer" greenprint.
        Greenprints[] layers = {explicit, lazy};
        Greenprints layered = new LayeredGreenprints(layers);
        return build(explicit, layered);
    }

    // FIX 1887 Expose this.  Make public.
    private Spider build(Redprints redprints, Greenprints greenprints) {
        Instances instances = nuInstances();
        Spider spider = assembler.assemble(greenprints, instances);
        Registry registry = new DefaultRegistry(redprints, instances);
        preregister(spider, registry);
        return spider;
    }

    private Greenprints greenprints(ImplMapper[] implMappers) {
        ImplMaster impler = new DefaultImplMaster(implMappers);
        return new LazyGreenprints(impler);
    }

    private ImplMapper[] mappers() {
        ImplMapper mapper = new BasicImplMapper();
        return new ImplMapper[]{mapper};
    }

    private void preregister(Spider spider, Registry registry) {
        registry.instance(Registry.class, registry);
        registry.instance(Resolver.class, spider);
        registry.instance(Injector.class, spider);
    }

    private Instances nuInstances() {
        FlavouredMap map = nuMap();
        return new DefaultInstances(map);
    }

    private Blueprints nuBlueprints() {
        FlavouredMap map = nuMap();
        return new DefaultBlueprints(map);
    }

    private FlavouredMap nuMap() {
        FlavouredMapEngine engine = new DefaultFlavouredMapEngine();
        return new DefaultFlavouredMap(engine);
    }
}
