package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultGraphBuilder implements GraphBuilder {
    private final InjectionWeb context;

    public DefaultGraphBuilder(InjectionWeb context) {
        this.context = context;
    }

    public Injection build(InjectionType type) {
        // FIX 2394 arbitraty values at the moment, warrants a special class
        InjectionSite site = new DefaultInjectionSite(GraphBuilder.class, type, "root");


        // FIX 2394 implement me
        return null;
    }
}
