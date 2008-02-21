package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.nursery.spider.layer.DefaultLayers;
import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.nursery.type.core.DefaultTypes;
import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.spider.register.BlueprintedFactory;
import au.net.netstorm.boost.spider.register.Blueprints;
import au.net.netstorm.boost.spider.register.BlueprintsRead;
import au.net.netstorm.boost.spider.register.DefaultBlueprints;
import au.net.netstorm.boost.spider.register.DefaultFactories;
import au.net.netstorm.boost.spider.register.DefaultInstances;
import au.net.netstorm.boost.spider.register.DefaultRegistry;
import au.net.netstorm.boost.spider.register.Factories;
import au.net.netstorm.boost.spider.register.Factory;
import au.net.netstorm.boost.spider.register.ImplicitFactory;
import au.net.netstorm.boost.spider.register.Instances;
import au.net.netstorm.boost.spider.register.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.util.impl.ImplMaster;

// FIX 2215 Why is this class in "demo"?  It's some sort of wirer?!

// DEBT DataAbstractionCoupling|NCSS {
public final class DefaultSpiderBuilder implements SpiderBuilder {
    private final SpiderAssembler assembler = new DefaultSpiderAssembler();

    public Spider build(ImplMaster impler) {
        Blueprints blueprints = new DefaultBlueprints();
        Factories factories = new DefaultFactories();
        Instances instances = new DefaultInstances();
        Layers proxies = new DefaultLayers();
        Spider spider = assembler.assemble(instances, factories, proxies);
        Registry registry = new DefaultRegistry(blueprints, instances, factories, proxies, spider);
        registerSpider(registry, spider);
        buildFactories(registry, impler, blueprints);
        buildTypes(registry, factories, spider);
        return spider;
    }

    private void registerSpider(Registry registry, Spider spider) {
        registry.instance(Registry.class, registry);
        registry.instance(Resolver.class, spider);
        registry.instance(Injector.class, spider);
        registry.instance(Nu.class, spider);
    }

    private void buildTypes(Registry registry, Factories factories, Nu nu) {
        LinkageFactory linkages = new DefaultLinkageFactory();
        Types types = new DefaultTypes(factories, linkages, nu);
        registry.instance(Types.class, types);
    }

    private void buildFactories(Registry registry, ImplMaster impler, Blueprints blueprints) {
        // FIX BREADCRUMB 2237 How do we enforce ordering?  High cost factories should be first registered, last called?
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
// } DEBT DataAbstractionCoupling|NCSS