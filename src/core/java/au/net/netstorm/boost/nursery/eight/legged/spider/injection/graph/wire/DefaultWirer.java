package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.InstanceCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.FieldInjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultWirer implements Wirer {
    public void wire(Node graph, Instances instances, Resolvables resolvables, Providers providers) {
        nu(graph, instances, providers);
    }

    private void nu(Node graph, Instances instances, Providers providers) {
        InstanceCreator creator = new InstanceCreator(providers, instances);
        visit(graph, instances, creator);
    }

    private void visit(Node graph, Instances instances, InstanceCreator creator) {
        InjectionSite site = graph.site();
        Object instance = instances.get(site, creator);
        for (Node node : graph) {
            hackItTogetherAKAwire(instance, node, instances, creator);
        }
    }

    // FIX 2394 nasty piece of hackery here.
    private void hackItTogetherAKAwire(Object host, Node node, Instances instances, InstanceCreator creator) {
        InjectionSite site = node.site();
        if (!(site instanceof FieldInjectionSite)) return;
        FieldInjectionSite field = (FieldInjectionSite) site;
        if (field.isWired(host)) return;
        visit(node, instances, creator);
        Object instance = instances.get(site, creator);
        field.inject(host, instance);
    }
}
