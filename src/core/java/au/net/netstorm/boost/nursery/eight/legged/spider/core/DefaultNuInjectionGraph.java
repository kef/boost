package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultNuInjectionGraph implements NuInjectionGraph {
    private final InjectionTypeBuilder types = new DefaultInjectionTypeBuilder();
    private final GraphBuilder builder;

    public DefaultNuInjectionGraph(GraphBuilder builder) {
        this.builder = builder;
    }

    public <T> InjectionGraph<T> nu(Class<T> root) {
        InjectionType type = types.build(root);
        Injection injection = builder.build(type);
        return new DefaultInjectionGraph(root, injection);
    }
}
