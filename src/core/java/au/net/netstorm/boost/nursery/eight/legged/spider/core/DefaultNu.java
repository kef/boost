package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionGraph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultNu implements Nu {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final GraphBuilder builder;

    public DefaultNu(GraphBuilder builder) {
        this.builder = builder;
    }

    // FIX 2394 push rename values to args all the way out
    public <T> T nu(Class<T> iface, Object... args) {
        // FIX 2394 need to verify this is an interface here
        InjectionType type = typer.build(iface);
        InjectionGraph<T> graph = builder.nu(iface, type, args);
        return graph.apply();
    }
}
