package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.PostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.SiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.Wirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 2394 splitter?
public final class DefaultLifecycle implements Lifecycle {
    private final Wirer wirer;
    private final PostProcessor poster;
    private final SiteWalker walker;

    public DefaultLifecycle(Wirer wirer, PostProcessor poster, SiteWalker walker) {
        this.wirer = wirer;
        this.poster = poster;
        this.walker = walker;
    }

    public Node build(InjectionSite root, Providers providers) {
        return walker.traverse(root, providers);
    }

    public void wire(Node graph, Instances instances, Providers providers) {
        wirer.wire(graph, instances, providers);
    }

    public void post(Resolver resolver, Instances instances) {
        poster.process(resolver, instances);
    }
}
