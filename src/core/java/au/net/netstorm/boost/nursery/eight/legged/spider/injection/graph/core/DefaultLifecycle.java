package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.PostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultSiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.SiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.Wirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultLifecycle implements Lifecycle {
    private final Instantiator instantiator;
    private final Wirer wirer;
    private final PostProcessor poster;

    public DefaultLifecycle(Instantiator instantiator, Wirer wirer, PostProcessor poster) {
        this.instantiator = instantiator;
        this.wirer = wirer;
        this.poster = poster;
    }

    // FIX 2394 smelly. site walker is currently stateful.
    public Node build(InjectionSite root, Providers providers, Resolvables resolvables) {
        SiteWalker walker = new DefaultSiteWalker(providers, resolvables);
        return walker.traverse(root);
    }

    public void instantiate(Providers providers, Instances instances) {
        // FIX 2394 skip this phase
//        instantiator.instantiate(providers, instances);
    }

    public void wire(Node graph, Instances instances, Resolvables resolvables, Providers providers) {
        wirer.wire(graph, instances, resolvables, providers);
    }

    public void post(Resolver resolver, Instances instances) {
        poster.process(resolver, instances);
    }
}
