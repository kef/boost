package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;

public final class DefaultGraphWirer implements GraphWirer {
    public Graph wire(FactoryResolver resolver, AspectResolver aspector, InjectionSite root, Object... args) {
        Providers providers = new DefaultProviders();
        Instances instances = new DefaultInstances();
        return args.length == 0
                ? new DefaultGraph(providers, instances, resolver, aspector, root)
                : new ParameterizedGraph(providers, instances, resolver, aspector, root, args);
    }
}
