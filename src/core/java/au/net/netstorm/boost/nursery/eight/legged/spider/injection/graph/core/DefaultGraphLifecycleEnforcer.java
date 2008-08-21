package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.gunge.optional.Optional;

// FIX 2394 rename. either LifecycleEnforce, or maybe GraphProtocol.
public final class DefaultGraphLifecycleEnforcer implements GraphLifecycleEnforcer {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final GraphWirer wirer;

    public DefaultGraphLifecycleEnforcer(GraphWirer wirer) {
        this.wirer = wirer;
    }

    // FIX 2394 Move this out into DefaultGrapher and shrink this back down.
    public Object apply(InjectionType type, Optional<Provider> provider, Object... args) {
        InjectionSite root = builder.root(type);
        LifecycleInstance stateful = wirer.nu(root, provider, args);
        return apply(stateful);
    }

    private Object apply(LifecycleInstance lifecycle) {
        lifecycle.build();
        lifecycle.instantiate();
        lifecycle.wire();
        lifecycle.post();
        return lifecycle.resolve();
    }
}
