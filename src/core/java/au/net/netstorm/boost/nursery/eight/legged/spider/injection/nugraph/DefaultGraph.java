package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.LazyProviderCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
// FIX 2394 need a graph wirer
// DEBT ClassDataAbstractionCoupling {
public final class DefaultGraph implements Graph {
    private final SiteWalker walker = new DefaultSiteWalker();
    private final Providers providers = new DefaultProviders();
    private final Instances instances = new DefaultInstances();
    private final Resolvables resolvables = new DefaultResolvables();
    private final Instantiator instantiator = new DefaultInstantiator();
    private final Wirer wirer = new DefaultWirer();
    private final FactoryResolver resolver;
    private final InjectionSite root;

    // FIX 2394 wrap graph in nice wrapper that holds the factory resolver for use in GraphBuilder
    public DefaultGraph(FactoryResolver resolver, InjectionSite root) {
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

    public void post() {
        // FIX 2394 implement post processing
    }

    public Object resolve() {
        Failer<InjectionSite> failer = new ResolutionFailer();
        return instances.get(root, failer);
    }

    public void add(InjectionSite site, Provider provider) {
        providers.put(site, provider);
    }

    public void resolvable(InjectionSite host, InjectionSite[] sites) {
        resolvables.add(host, sites);
    }
}
// } DEBT ClassDataAbstractionCoupling
