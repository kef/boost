package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 1676 Test drive.  This triggers work on "why use facades" discussion paper.
public final class DefaultSpider implements Spider {
    private final NuImpl nuImpl;
    private final Injector injector;
    private final Resolver resolver;

    public DefaultSpider(NuImpl nuImpl, Injector injector, Resolver resolver) {
        this.nuImpl = nuImpl;
        this.injector = injector;
        this.resolver = resolver;
    }

    public <T> T nu(Class<T> impl, Object... params) {
        return nuImpl.nu(impl, params);
    }

    public void inject(Object ref) {
        injector.inject(ref);
    }

    public <T> T resolve(Class<T> type) {
        return resolver.resolve(type);
    }
}
