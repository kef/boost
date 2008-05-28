package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;

public final class DefaultGraphBuilder implements GraphBuilder {
    private final InjectionWeb context;

    public DefaultGraphBuilder(InjectionWeb context) {
        this.context = context;
    }

    public Injection build(Class<?> root) {
        // FIX 2394 implement me
        return null;
    }
}
