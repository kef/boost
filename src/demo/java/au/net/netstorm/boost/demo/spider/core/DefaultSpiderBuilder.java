package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMap;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMapEngine;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.flavour.FlavouredMapEngine;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.DefaultInstances;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.Greenprints;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.LayeredGreenprints;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 1914 Move these out of here.  Web, LazyGreens, SpiderBuilder.
public final class DefaultSpiderBuilder implements SpiderBuilder {
    private final SpiderAssembler assembler = new DefaultSpiderAssembler();

    public Spider build() {
        // FIX 57384 Remove the following code ???
        Blueprints explicit = nuBlueprints();
        Greenprints lazy = new LazyGreenprints();
        Greenprints[] layers = {explicit, lazy};
        Greenprints layered = new LayeredGreenprints(layers);
        Instances instances = nuInstances();
        Spider spider = assembler.assemble(layered, instances);
        Registry registry = new DefaultRegistry(explicit, instances);
        registry.instance(Registry.class, registry);
        registry.instance(Resolver.class, spider);
        return spider;
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
