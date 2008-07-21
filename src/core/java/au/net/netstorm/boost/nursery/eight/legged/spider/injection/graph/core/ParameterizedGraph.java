package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Argumentor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultArgumentor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core.Graph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core.DefaultGraph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.PostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;



// FIX 2394 tidy this beast up. should be able to make it really lean.
// DEBT ClassDataAbstractionCoupling|ParameterNumber|LineLength {
public final class ParameterizedGraph implements Graph {
    private final Instantiator instantiator = new DefaultInstantiator();
    private final Argumentor argumentor = new DefaultArgumentor();
    private final Graph delegate;
    private final InjectionSite root;
    private final Object[] args;
    private final Providers providers;
    private final Instances instances;

    // FIX 2394 wrap graph in nice wrapper that holds the factory resolver for use in GraphBuilder
    public ParameterizedGraph(Providers providers, Instances instances, PostProcessor poster, InjectionSite root, Object... args) {
        // FIX 2394 move to wirer
        this.delegate = new DefaultGraph(providers, instances, poster, root);
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

// } DEBT ClassDataAbstractionCoupling|ParameterNumber|LineLength