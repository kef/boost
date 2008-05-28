package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionGraph;


// FIX 2394 no difference between nu without parameters and resolver, suggest kill Resolver
public final class DefaultResolver implements Resolver {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final GraphBuilder builder;

    public DefaultResolver(GraphBuilder builder) {
        this.builder = builder;
    }

    public <T> T resolve(Class<T> cls) {
        InjectionType type = typer.build(cls);
        InjectionGraph<T> graph = builder.build(cls, type);
        return graph.apply();
    }
}