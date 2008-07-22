package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core.Grapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultNu implements Nu {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final Grapher grapher;

    public DefaultNu(Grapher grapher) {
        this.grapher = grapher;
    }

    public <T> T nu(Class<T> iface, Object... args) {
        // FIX 2394 need to pull this logic out of DefaultInterface
        new DefaultInterface(iface);
        InjectionType<T> type = typer.build(iface);
        return grapher.graph(type, args);
    }
}
