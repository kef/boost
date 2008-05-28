package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;

// FIX 2394 test me
public final class DefaultInjector implements Injector {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final GraphBuilder builder;

    public DefaultInjector(GraphBuilder builder) {
        this.builder = builder;
    }

    public void inject(Object ref) {
        // FIX 2394 expose field injector here
        throw new UnsupportedOperationException();
    }
}
