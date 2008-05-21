package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.registry.BlueprintsRead;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.gunge.type.Implementation;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public final class BlueprintedProviderFactory implements ProviderFactory {
    private final BlueprintsRead blueprints;

    public BlueprintedProviderFactory(BlueprintsRead blueprints) {
        this.blueprints = blueprints;
    }

    public boolean canHandle(InjectionSite site) {
        Linkage linkage = site.toLinkage();
        return canHandle(linkage);
    }

    public Provider nu(InjectionSite site) {
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
