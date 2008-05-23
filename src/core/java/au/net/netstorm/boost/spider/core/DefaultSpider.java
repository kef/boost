package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.registry.Registry;

// FIX 1676 Test drive.  This triggers work on "why use facades" discussion paper.
public final class DefaultSpider implements Spider {
    private final Nu nu;
    private final Injector injector;
    private final Resolver resolver;
    private final Registry registry;

    public DefaultSpider(Nu nu, Injector injector, Resolver resolver, Registry registry) {
        this.nu = nu;
        this.injector = injector;
        this.resolver = resolver;
        this.registry = registry;
    }

    // FIX 2394 remove me once assembler is unwound from itself
    public Registry dirtyHackAllowsBootstrapToAvoidBugThatThingsCantBeResolvedIfThereAreNoFactories() {
        return registry;
    }

    public <T> T nu(Class<T> iface, Object... params) {
        return nu.nu(iface, params);
    }

    public void inject(Object ref) {
        injector.inject(ref);
    }

    public <T> T resolve(Class<T> type) {
        return resolver.resolve(type);
    }
}
