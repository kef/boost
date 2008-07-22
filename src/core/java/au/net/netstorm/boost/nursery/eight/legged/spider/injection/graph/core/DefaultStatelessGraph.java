package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.PostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.SiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultSiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.Wirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultStatelessGraph implements StatelessGraph {
    private final Instantiator instantiator;
    private final Wirer wirer;
    private final PostProcessor poster;

    public DefaultStatelessGraph(Instantiator instantiator, Wirer wirer, PostProcessor poster) {
        this.instantiator = instantiator;
        this.wirer = wirer;
        this.poster = poster;
    }

    // FIX 2394 smelly. site walker is currently stateful.
    public void build(InjectionSite root, Providers providers, Resolvables resolvables) {
        SiteWalker walker = new DefaultSiteWalker(providers, resolvables);
        walker.traverse(root);
    }

    public void instantiate(Providers providers, Instances instances) {
        instantiator.instantiate(providers, instances);
    }

    public void wire(Instances instances, Resolvables resolvables) {
        wirer.wire(instances, resolvables);
    }

    public void post(Instances instances) {
        poster.process(instances);
    }
}
