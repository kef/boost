package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.util.HashSet;
import java.util.Set;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 massive :(
// DEBT ClassDataAbstractionCoupling {
public final class DefaultGraph implements Graph {
    private final SiteWalker walker = new DefaultSiteWalker();
    private final Set walked = new HashSet();
    private final Resolvables resolvables = new DefaultResolvables();
    private final Instantiator instantiator = new DefaultInstantiator();
    private final Wirer wirer = new DefaultWirer();
    private final PostProcessor poster = new DefaultPostProcessor();
    private final Providers providers;
    private final Instances instances;
    private final FactoryResolver resolver;
    private final InjectionSite root;

    // FIX 2394 wrap graph in nice wrapper that holds the factory resolver for use in GraphBuilder
    public DefaultGraph(Providers providers, Instances instances, FactoryResolver resolver, InjectionSite root) {
        this.providers = providers;
        this.instances = instances;
        this.resolver = resolver;
        this.root = root;
    }

    public Provider provide(InjectionSite site) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return providers.get(site, creator);
    }

    public void build() {
        walker.traverse(this, root);
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

    public void add(InjectionSite site, Provider provider) {
        providers.put(site, provider);
    }

    public void walking(InjectionSite site) {
        walked.add(site);
    }

    public boolean hasWalked(InjectionSite site) {
        return walked.contains(site);
    }

    public void resolvable(InjectionSite host, InjectionSite[] sites) {
        resolvables.add(host, sites);
    }
}
// } DEBT ClassDataAbstractionCoupling
