package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Argumentor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultArgumentor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;



// FIX 2394 tidy this beast up. should be able to make it really lean.
// DEBT ParameterNumber {
public final class ParameterizedGraph implements Graph {
    // FIX 2394 move to wirer
    private final Instantiator instantiator = new DefaultInstantiator();
    private final Argumentor argumentor = new DefaultArgumentor();
    private final Graph delegate;
    private final InjectionSite root;
    private final Object[] args;
    private final Providers providers;
    private final Instances instances;

    public ParameterizedGraph(
            Graph delegate, 
            Providers providers,
            Instances instances,
            InjectionSite root,
            Object... args
    ) {
        this.delegate = delegate;
        this.providers = providers;
        this.instances = instances;
        this.root = root;
        this.args = args;
    }

    public void build() {
        Provider provider = providers.getOrCreate(root);
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
}

// } DEBT ParameterNumber