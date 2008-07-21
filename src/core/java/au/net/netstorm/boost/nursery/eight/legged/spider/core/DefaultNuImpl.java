package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core.Grapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class DefaultNuImpl implements NuImpl {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final Grapher grapher;

    public DefaultNuImpl(Grapher grapher) {
        this.grapher = grapher;
    }

    public <T> T nu(Class<T> cls, Object... args) {
        InjectionType<T> type = typer.build(cls);
        return grapher.graph(type, args);
    }
}
