package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.resolve.SpiderWeb;

// FIX 1676 Test drive.  This triggers work on "compose".
public final class DefaultSpider implements Spider {
    private final Provider provider;
    private final Injector injector;
    private final Resolver resolver;
    private final SpiderWeb web;

    public DefaultSpider(Provider provider, Injector injector, Resolver resolver, SpiderWeb web) {
        this.provider = provider;
        this.injector = injector;
        this.resolver = resolver;
        this.web = web;
    }

    public Object provide(Class type) {
        return provider.provide(type);
    }

    public Object provide(Class type, Object[] parameters) {
        return provider.provide(type, parameters);
    }

    public void inject(Object ref) {
        injector.inject(ref);
    }

    public Object resolve(Class type) {
        return resolver.resolve(type);
    }

    public void prototype(Class iface, Class impl) {
        web.prototype(iface, impl);
    }

    public void instance(Class iface, Object ref) {
        web.instance(iface, ref);
    }
}
