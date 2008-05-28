package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.gunge.type.Implementation;

public final class BlueprintedFactory implements ConfigurableFactory {
    private final Blueprints blueprints = new DefaultBlueprints();

    public void configure(Web web) {
        // FIX 2394 store blueprints state in web
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
