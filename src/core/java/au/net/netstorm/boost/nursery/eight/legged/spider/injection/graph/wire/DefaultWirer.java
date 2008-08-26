package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire;

import java.util.LinkedList;
import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.InstanceCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.Constructables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.FieldInjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultWirer implements Wirer {
    private final Constructables constructables;

    public DefaultWirer(Constructables constructables) {
        this.constructables = constructables;
    }

    public void wire(Node graph, Instances instances, Providers providers) {
        List todo = new LinkedList();
        InstanceCreator creator = new InstanceCreator(providers, instances, todo);
        visit(graph, instances, creator);
        for (Object ref : todo) {
            constructables.construct(ref);
        }
    }

    private void visit(Node graph, Instances instances, InstanceCreator creator) {
        InjectionSite site = graph.site();
        Object instance = instances.get(site, creator);
        while(graph.available()) {
            Node node = graph.take();
            hackItTogetherAKAwire(instance,  node, instances, creator);
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
