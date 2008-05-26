package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPatternBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.DefaultInjectionPatternBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.gunge.type.Implementation;

// FIX 2394 just giving some concepts a name and trying to map them to existing functionality
public final class BlueprintedFactory implements ConfigurableFactory {
    private final InjectionPatternBuilder patterner = new DefaultInjectionPatternBuilder();
    private final Blueprints blueprints = new DefaultBlueprints();

    public void configure(Web web) {
        web.single().type(Blueprints.class).to(blueprints);
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
