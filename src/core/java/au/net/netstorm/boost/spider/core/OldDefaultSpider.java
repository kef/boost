package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 1676 Test drive.  This triggers work on "why use facades" discussion paper.
public final class OldDefaultSpider implements Spider {
    private final Nu nu;
    private final Injector injector;
    private final Resolver resolver;

    public OldDefaultSpider(Nu nu, Injector injector, Resolver resolver) {
        this.nu = nu;
        this.injector = injector;
        this.resolver = resolver;
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
