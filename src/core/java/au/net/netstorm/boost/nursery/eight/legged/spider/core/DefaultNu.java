package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Grapher;
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

    // FIX 2394 push rename values to args all the way out
    public <T> T nu(Class<T> iface, Object... args) {
        // FIX 2394 need to pull this logic out of DefaultInterface
        new DefaultInterface(iface);
        InjectionType<T> type = typer.build(iface);
        return grapher.graph(type, args);
    }
}
