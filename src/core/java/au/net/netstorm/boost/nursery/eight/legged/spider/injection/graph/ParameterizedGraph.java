package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 massive :(
// FIX 2394 use or lose. building parrallel implementation for better graph builder.
// FIX 2394 need a graph wirer

// DEBT ClassDataAbstractionCoupling|ParameterNumber|LineLength {
public final class ParameterizedGraph implements Graph {
    private final Instantiator instantiator = new DefaultInstantiator();
    private final Argumentor argumentor = new DefaultArgumentor();
    private final Graph delegate;
    private final InjectionSite root;
    private final Object[] args;
    private final FactoryResolver resolver;
    private final Providers providers;
    private final Instances instances;

    // FIX 2394 wrap graph in nice wrapper that holds the factory resolver for use in GraphBuilder
    public ParameterizedGraph(Providers providers, Instances instances, FactoryResolver resolver, InjectionSite root, Object... args) {
        this.delegate = new DefaultGraph(providers, instances, resolver, root);
        this.args = args;
        this.root = root;
        this.resolver = resolver;
        this.providers = providers;
        this.instances = instances;
    }

    public Provider provide(InjectionSite site) {
        return delegate.provide(site);
    }

    public void build() {
        Provider provider = provide(root);
        argumentor.providers(providers, provider, root, args);
        delegate.build();
    }

    public void instantiate() {
        instantiator.instantiate(providers, instances, root, args);
        delegate.instantiate();
    }

    public void wire() {
        delegate.wire();
    }

    public void post() {
        delegate.post();
    }

    public Object resolve() {
        return delegate.resolve();
    }

    public void add(InjectionSite site, Provider provider) {
        delegate.add(site, provider);
    }

    public void walking(InjectionSite site) {
        delegate.walking(site);
    }

    public boolean hasWalked(InjectionSite site) {
        return delegate.hasWalked(site);
    }

    public void resolvable(InjectionSite host, InjectionSite[] sites) {
        delegate.resolvable(host, sites);
    }
}

// } DEBT ClassDataAbstractionCoupling|ParameterNumber|LineLength