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

// FIX 2394 split into ProviderWirer.
public final class DefaultStatefulGraphWirer implements StatefulGraphWirer {
    private final ProvidersWirer wirer;
    private final FactoryResolver resolver;
    private final StatelessGraph graph;

    public DefaultStatefulGraphWirer(FactoryResolver resolver, AspectResolver aspector) {
        this.resolver = resolver;
        this.graph = graph(aspector);
        this.wirer = new DefaultProvidersWirer(resolver);
    }

    public StatefulGraph wire(InjectionSite root, Provider provider, Object... args) {
        Instances instances = new DefaultInstances();
        Resolvables resolvables = new DefaultResolvables();
        Providers providers = wirer.wire(instances, provider, root, args);
        return new DefaultStatefulGraph(graph, providers, instances, resolvables, root);
    }


    private StatelessGraph graph(AspectResolver aspector) {
        StatelessGraphWirer wirer = new DefaultStatelessGraphWirer(aspector);
        return wirer.wire();
    }
}
