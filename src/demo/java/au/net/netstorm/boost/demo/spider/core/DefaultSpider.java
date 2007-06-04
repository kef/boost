package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 1676 Test drive.  This triggers work on "why use facades" discussion paper.
public final class DefaultSpider implements Spider {
    private final Provider provider;
    private final Injector injector;
    private final Resolver resolver;

    public DefaultSpider(Provider provider, Injector injector, Resolver resolver) {
        this.provider = provider;
        this.injector = injector;
        this.resolver = resolver;
    }

    public Object provide(Class type) {
        return provider.provide(type);
    }

    public void inject(Object ref) {
        injector.inject(ref);
    }

    public Object resolve(Class type) {
        return resolver.resolve(type);
    }
}
