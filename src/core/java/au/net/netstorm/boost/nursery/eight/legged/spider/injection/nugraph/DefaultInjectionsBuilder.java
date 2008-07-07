package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultInjectionsBuilder implements InjectionsBuilder {
    private final InstantiationBuilder instantiaton = new DefaultInstantiationBuilder();
    private final ResolutionBuilder resolution = new DefaultResolutionBuilder();
    private final PostProcessorBuilder postprocessing = new DefaultPostProcessorBuilder();

    public Injections build(InjectionSite site) {
        Injections injections = new DefaultInjections();
        build(injections, site);
        return injections;
    }

    // FIX BREADCRUMB 2394 aaaaaaaaaaaaaaaaaaa pushing this guy out
    public void build(Injections injections, InjectionSite site) {
        instantiaton.build(injections, site);
        resolution.build(injections, site);
        postprocessing.build(injections, site);
    }
}
