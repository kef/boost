package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.protocol;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.data.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.resolve.Resolver;

// OK ParameterNumber {
// FIX 2394 kill this class.
public final class DefaultProtocolInstance implements ProtocolInstance {
    private final Providers providers;
    private final Instances instances;
    private final Protocol protocol;
    private final InjectionSite root;
    private final Resolver resolver;
    private Node graph;

    public DefaultProtocolInstance(
            Protocol protocol,
            Providers providers,
            Instances instances,
            InjectionSite root,
            Resolver resolver
    ) {
        this.protocol = protocol;
        this.root = root;
        this.instances = instances;
        this.providers = providers;
        this.resolver = resolver;
    }

    public void build() {
        // FIX 2394 maybe pass in instead of return
        graph = protocol.build(root, providers);
    }

    public void wire() {
        protocol.wire(graph, instances, providers);
    }

    public void post() {
        protocol.post(resolver, instances);
    }

    public Object resolve() {
        return instances.get(root);
    }
}
// } OK ParameterNumber
