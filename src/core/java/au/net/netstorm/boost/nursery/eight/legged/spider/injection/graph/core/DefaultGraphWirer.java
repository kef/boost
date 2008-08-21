package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.ProvidersWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultProvidersWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.DefaultResolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.gunge.optional.Optional;
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
        Instances instances = new DefaultInstances();
        Resolvables resolvables = new DefaultResolvables();
        Providers providers = wirer.nu(instances, provider, root, args);
        return new DefaultLifecycleInstance(graph, providers, instances, resolvables, root, resolver);
    }

    private Lifecycle graph(AspectResolver aspector) {
        StatelessGraphWirer wirer = new DefaultStatelessGraphWirer(aspector);
        return wirer.nu();
    }
}
