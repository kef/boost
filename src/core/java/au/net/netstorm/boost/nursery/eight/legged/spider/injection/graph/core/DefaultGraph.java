package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.resolve.Resolver;

// OK ParameterNumber {
public final class DefaultGraph implements Graph {
    private final Providers providers;
    private final Instances instances;
    private final Resolvables resolvables;
    private final StatelessGraph graph;
    private final InjectionSite root;
    private final Resolver resolver;

    public DefaultGraph(
            StatelessGraph graph,
            Providers providers,
            Instances instances,
            Resolvables resolvables,
            InjectionSite root,
            Resolver resolver
    ) {
        this.graph = graph;
        this.root = root;
        this.instances = instances;
        this.resolvables = resolvables;
        this.providers = providers;
        this.resolver = resolver;
    }

    public void build() {
        graph.build(root, providers, resolvables);
    }

    public void instantiate() {
        graph.instantiate(providers, instances);
    }

    public void wire() {
        graph.wire(instances, resolvables);
    }

    public void post() {
        graph.post(resolver, instances);
    }

    public Object resolve() {
        return instances.get(root);
    }
}
// } OK ParameterNumber
