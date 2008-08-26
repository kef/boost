package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.data.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.FieldInjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultWirer implements Wirer {
    public void wire(Node graph, Instances instances, Providers providers) {
        visit(graph, instances);
    }

    private void visit(Node graph, Instances instances) {
        InjectionSite site = graph.site();
        Object instance = instances.getXXX(site);
        while(graph.available()) {
            Node node = graph.take();
            hackItTogetherAKAwire(instance,  node, instances);
        }
    }

    // FIX 2394 nasty piece of hackery here.
    private void hackItTogetherAKAwire(Object host, Node node, Instances instances) {
        InjectionSite site = node.site();
        if (!(site instanceof FieldInjectionSite)) return;
        FieldInjectionSite field = (FieldInjectionSite) site;
        if (field.isWired(host)) return;
        visit(node, instances);
        Object instance = instances.getXXX(site);
        field.inject(host, instance);
    }
}
