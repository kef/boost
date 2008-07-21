package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 massive :(
// DEBT ClassDataAbstractionCoupling|ParameterNumber|LineLength {
public final class DefaultGraph implements Graph {
    // FIX 2394 move all instantiation to wiring.
    private final SiteWalker walker ;
    private final Resolvables resolvables = new DefaultResolvables();
    private final Instantiator instantiator = new DefaultInstantiator();
    private final Wirer wirer = new DefaultWirer();
    private final PostProcessor poster;
    private final Providers providers;
    private final Instances instances;
    private final InjectionSite root;

    // FIX 2394 wrap graph in nice wrapper that holds the factory resolver for use in GraphBuilder
    public DefaultGraph(Providers providers, Instances instances, PostProcessor poster, InjectionSite root) {
        this.providers = providers;
        this.instances = instances;
        this.poster = poster;
        this.root = root;
        this.walker = new DefaultSiteWalker(providers, resolvables);
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

    // FIX 2394 implement post processing
    // FIX 2394 still a big question, whether to implement Constructable as a lifecycle aspect or process queue.
    // FIX 2394 using an aspect gives transparency to providers, but is a bit unweildy
    public void post() {
        poster.process(instances);
    }

    public Object resolve() {
        Failer<InjectionSite> failer = new ResolutionFailer();
        return instances.get(root, failer);
    }
}
// } DEBT ClassDataAbstractionCoupling|ParameterNumber|LineLength
