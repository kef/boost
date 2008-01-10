package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.nursery.spider.registry.DefaultFactories;
import au.net.netstorm.boost.nursery.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.registry.BlueprintedFactory;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.BlueprintsRead;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.DefaultInstances;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.ImplicitFactory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.util.impl.ImplMaster;

// FIX 2215 Sort out builder/assembler discrepancy.
// FIX 2215 Refactor.  Too messy.

// FIX 1914 Move these out of here.  Web, LazyGreens, SpiderBuilder.

// FIX 2215 Why is this class in "demo"?  It's some sort of wirer?!

// DEBT DataAbstractionCoupling {
public final class DefaultSpiderBuilder implements SpiderBuilder {
    private final SpiderAssembler assembler = new DefaultSpiderAssembler();

    public Spider build(ImplMaster impler) {
        Spider spider = doBuild(impler);
        preregister(spider, impler);
        return spider;
    }

    private Spider doBuild(ImplMaster impler) {
        Blueprints blueprints = new DefaultBlueprints();
        Factories factories = new DefaultFactories();
        Instances instances = new DefaultInstances();
        Spider spider = assembler.assemble(instances, factories);
        Registry registry = createRegistry(blueprints, factories, instances, spider);
        preregister(registry, spider, blueprints, impler);
        return spider;
    }

    private Registry createRegistry(Blueprints blueprints, Factories factories, Instances instances, Spider spider) {
        return new DefaultRegistry(blueprints, instances, factories, spider);
    }

    private void preregister(Spider spider, ImplMaster impler) {
        Registry registry = spider.resolve(Registry.class);
        registry.instance(ImplMaster.class, impler);
    }

    private void preregister(Registry registry, Spider spider, Blueprints blueprints, ImplMaster impler) {
        registry.instance(Registry.class, registry);
        registry.instance(Resolver.class, spider);
        registry.instance(Injector.class, spider);
        registry.instance(Nu.class, spider);
        // FIX BREADCRUMB 2215 How do we enforce ordering?  High cost factories should be first registered, last called?
        // FIX (Nov 28, 2007) IOC 2215 Can we register the impliers and blueprints in the spider and inject
        // FIX (Nov 28, 2007) IOC 2215 all factories?
        implicitFactory(registry, impler);
        blueprintedFactory(registry, blueprints);
    }

    private void implicitFactory(Registry registry, ImplMaster impler) {
        Factory factory = new ImplicitFactory(impler);
        registry.factory(factory);
    }

    private void blueprintedFactory(Registry registry, BlueprintsRead blueprints) {
        Factory factory = new BlueprintedFactory(blueprints);
        registry.factory(factory);
    }
}
// } DEBT DataAbstractionCoupling