package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ConfigurableFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.Stamp;

public final class BlueprintedFactory implements ConfigurableFactory {
    private final Blueprints blueprints = new DefaultBlueprints();

    public void configure(Binder binder) {
        binder.bind(Blueprints.class).to(blueprints);
    }

    public boolean canHandle(InjectionSite site) {
        Linkage linkage = site.toLinkage();
        return canHandle(linkage);
    }

    public Provider nu(InjectionSite site) {
        // FIX 2394 kill this linkage stuff
        Linkage linkage = site.toLinkage();
        if (!canHandle(linkage)) throw new IllegalArgumentException("Can't handle this site.");
        Blueprint blueprint = blueprints.get(linkage);
        return nuProvider(blueprint);
    }

    private boolean canHandle(Linkage linkage) {
        return blueprints.exists(linkage);
    }

    private Provider nuProvider(Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        Stamp stamp = blueprint.getStamp();
//        return stamp == Stamp.SINGLE ? new SingleProvider(impl) : new MultiProvider(impl);
        return null;
    }
}
