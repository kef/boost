package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionGraph;

// FIX 2394 test me
public final class DefaultNu implements Nu {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final GraphBuilder builder;

    public DefaultNu(GraphBuilder builder) {
        this.builder = builder;
    }

    // FIX 2394 rename values to args
    public <T> T nu(Class<T> iface, Object... values) {
        InjectionType type = typer.build(iface);
        InjectionGraph<T> graph = builder.build(iface, type, values);
        return graph.apply();
    }
}
