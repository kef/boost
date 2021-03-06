package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.protocol;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.data.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.resolve.Resolver;

public interface Protocol {
    Node build(InjectionSite root, Providers providers);

    void wire(Node graph, Instances instances, Providers providers);

    void post(Resolver resolver, Instances instances);
}
