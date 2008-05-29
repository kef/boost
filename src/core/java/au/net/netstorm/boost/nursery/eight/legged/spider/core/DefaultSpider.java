package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultSpider implements Spider {
    private final Nu nu;
    private final Injector injector;
    private final Resolver resolver;

    public DefaultSpider(Nu nu, Injector injector, Resolver resolver) {
        this.nu = nu;
        this.injector = injector;
        this.resolver = resolver;
    }

    public <T> T nu(Class<T> iface, Object... values) {
        return nu.nu(iface, values);
    }

    public void inject(Object ref) {
        injector.inject(ref);
    }

    public <T> T resolve(Class<T> type) {
        return resolver.resolve(type);
    }

    // FIX 2394 old spider issue - kill me
    public Registry dirtyHackAllowsBootstrapToAvoidBugThatThingsCantBeResolvedIfThereAreNoFactories() {
        throw new UnsupportedOperationException();
    }
}
