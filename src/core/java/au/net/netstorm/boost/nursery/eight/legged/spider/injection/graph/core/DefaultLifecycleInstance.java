package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.resolve.Resolver;

// OK ParameterNumber {
// FIX 2394 kill this class.
public final class DefaultLifecycleInstance implements LifecycleInstance {
    private final Providers providers;
    private final Instances instances;
    private final Lifecycle lifecycle;
    private final InjectionSite root;
    private final Resolver resolver;
    private Node graph;

    public DefaultLifecycleInstance(
            Lifecycle lifecycle,
            Providers providers,
            Instances instances,
            InjectionSite root,
            Resolver resolver
    ) {
        this.lifecycle = lifecycle;
        this.root = root;
        this.instances = instances;
        this.providers = providers;
        this.resolver = resolver;
    }

    public void build() {
        // FIX 2394 maybe pass in instead of return
        graph = lifecycle.build(root, providers);
    }

    public void wire() {
        lifecycle.wire(graph, instances, providers);
    }

    public void post() {
        lifecycle.post(resolver, instances);
    }

    public Object resolve() {
        return instances.get(root);
    }
}
// } OK ParameterNumber
