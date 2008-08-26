package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.gunge.optional.Optional;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultProvidersWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.ProvidersWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultGraphWirer implements GraphWirer {
    private final ProvidersWirer wirer;
    private final Lifecycle graph;
    private final Resolver resolver;

    public DefaultGraphWirer(FactoryResolver factories, AspectResolver aspector, Resolver resolver) {
        this.resolver = resolver;
        this.graph = graph(aspector);
        this.wirer = new DefaultProvidersWirer(factories);
    }

    public LifecycleInstance nu(InjectionSite root, Optional<Provider> provider, Object[] args) {
        Providers providers = wirer.nu(provider, root, args);
        Instances instances = new DefaultInstances(providers);
        return new DefaultLifecycleInstance(graph, providers, instances, root, resolver);
    }

    private Lifecycle graph(AspectResolver aspector) {
        StatelessGraphWirer wirer = new DefaultLifecycleWirer(aspector);
        return wirer.nu();
    }
}
