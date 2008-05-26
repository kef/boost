package au.net.netstorm.boost.spider.builder;

import au.net.netstorm.boost.gunge.impl.ImplMaster;
import au.net.netstorm.boost.nursery.spider.layer.DefaultLayers;
import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.registry.BlueprintedFactory;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.BlueprintsRead;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.DefaultFactories;
import au.net.netstorm.boost.spider.registry.DefaultInstances;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.ImpliciedFactory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Registry;

// FIX 2215 Why is this class in "demo"?  It's some sort of wirer?!

// DEBT DataAbstractionCoupling|NCSS {
public final class DefaultSpiderBuilder implements SpiderBuilder {
    private final SpiderAssembler assembler = new DefaultSpiderAssembler();

    public Spider build(ImplMaster impler) {
        Blueprints blueprints = new DefaultBlueprints();
        Factories factories = new DefaultFactories();
        Instances instances = new DefaultInstances();
        Layers proxies = new DefaultLayers();
        Spider spider = assembler.assemble(instances, factories, blueprints, proxies);
        buildFactories(spider, impler, blueprints);
        return spider;
    }


    private void buildFactories(Spider spider, ImplMaster impler, Blueprints blueprints) {
        // FIX BREADCRUMB 2237 How do we enforce ordering?  High cost factories should be first registered, last called?
        // FIX (Nov 28, 2007) IOC 2215 Can we register the impliers and blueprints in the spider and inject
        // FIX (Nov 28, 2007) IOC 2215 all factories?
        Registry registry = spider.dirtyHackAllowsBootstrapToAvoidBugThatThingsCantBeResolvedIfThereAreNoFactories();
        implicitFactory(registry, impler);
        blueprintedFactory(registry, blueprints);
    }

    private void implicitFactory(Registry registry, ImplMaster impler) {
        Factory factory = new ImpliciedFactory(impler);
        registry.factory(factory);
    }

    private void blueprintedFactory(Registry registry, BlueprintsRead blueprints) {
        Factory factory = new BlueprintedFactory(blueprints);
        registry.factory(factory);
    }
}
// } DEBT DataAbstractionCoupling|NCSS