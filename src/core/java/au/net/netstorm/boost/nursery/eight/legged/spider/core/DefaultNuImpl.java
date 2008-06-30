package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionGraph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class DefaultNuImpl implements NuImpl {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final GraphBuilder builder;

    public DefaultNuImpl(GraphBuilder builder) {
        this.builder = builder;
    }

    // FIX 2394 push rename values to args all the way out
    public <T> T nu(Class<T> impl, Object... args) {
        InjectionType type = typer.build(impl);
        InjectionGraph<T> graph = builder.nuImpl(impl, type, args);
        return graph.apply();
    }
}
