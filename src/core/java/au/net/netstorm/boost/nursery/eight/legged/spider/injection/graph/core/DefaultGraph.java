package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.PostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultSiteState;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.SiteState;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.SiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.ResolutionFailer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.Wirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 fragile :(
// DEBT ParameterNumber {
public final class DefaultGraph implements Graph {
    private final SiteWalker walker ;
    private final Resolvables resolvables;
    private final Instantiator instantiator;
    private final Wirer wirer;
    private final PostProcessor poster;
    private final Providers providers;
    private final Instances instances;
    private final InjectionSite root;

    public DefaultGraph(SiteWalker walker, Instantiator instantiator, Wirer wirer, PostProcessor poster, Providers providers, Instances instances, Resolvables resolvables, InjectionSite root) {
        this.walker = walker;
        this.instantiator = instantiator;
        this.wirer = wirer;
        this.poster = poster;
        this.providers = providers;
        this.instances = instances;
        this.resolvables = resolvables;
        this.root = root;
    }

    public void build() {
        SiteState state = new DefaultSiteState();
        walker.traverse(state, root);
    }

    public void instantiate() {
        instantiator.instantiate(providers, instances);
    }

    public void wire() {
        wirer.wire(instances, resolvables);
    }

    public void post() {
        poster.process(instances);
    }

    public Object resolve() {
        Failer<InjectionSite> failer = new ResolutionFailer();
        return instances.get(root, failer);
    }
}
// } DEBT ParameterNumber
