package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionGraph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.spider.inject.core.Injector;

public final class DefaultInjector implements Injector {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final GraphBuilder builder;

    public DefaultInjector(GraphBuilder builder) {
        this.builder = builder;
    }

    public void inject(Object ref) {
        Class<?> cls = ref.getClass();
        InjectionType type = typer.build(cls);
        InjectionGraph<?> graph = builder.inject(cls, type, ref);
        graph.apply();
    }
}
