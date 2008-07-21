package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core.Grapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.spider.resolve.Resolver;


public final class DefaultResolver implements Resolver {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final Grapher grapher;

    public DefaultResolver(Grapher grapher) {
        this.grapher = grapher;
    }

    public <T> T resolve(Class<T> cls) {
        InjectionType<T> type = typer.build(cls);
        return grapher.graph(type);
    }
}
