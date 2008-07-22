package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultGraphLifecycleEnforcer implements GraphLifecycleEnforcer {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final StatefulGraphWirer wirer;

    public DefaultGraphLifecycleEnforcer(StatefulGraphWirer wirer) {
        this.wirer = wirer;
    }

    public Object apply(InjectionType type, Provider provider, Object... args) {
        InjectionSite root = builder.root(type);
        StatefulGraph stateful = wirer.wire(root, provider, args);
        return apply(stateful);
    }

    private Object apply(StatefulGraph graph) {
        graph.build();
        graph.instantiate();
        graph.wire();
        graph.post();
        return graph.resolve();
    }
}
