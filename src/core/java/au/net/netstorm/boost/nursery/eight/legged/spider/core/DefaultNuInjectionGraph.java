package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;

public final class DefaultNuInjectionGraph implements NuInjectionGraph {
    private final GraphBuilder builder;

    public DefaultNuInjectionGraph(GraphBuilder builder) {
        this.builder = builder;
    }

    public <T> InjectionGraph<T> nu(Class<T> root) {
        Injection injection = builder.build(root);
        return new DefaultInjectionGraph(root, injection);
    }
}
