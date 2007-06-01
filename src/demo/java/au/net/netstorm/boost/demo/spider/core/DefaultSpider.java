package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;

// FIX 1676 Test drive.  This triggers work on "why use facades" discussion paper.
public final class DefaultSpider implements Spider {
    private final Provider provider;
    private final Injector injector;
    private final Resolver resolver;
    private final Registry registry;

    public DefaultSpider(Provider provider, Injector injector, Resolver resolver, Registry registry) {
        this.provider = provider;
        this.injector = injector;
        this.resolver = resolver;
        this.registry = registry;
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

    public void multiple(Class iface, Class impl) {
        registry.multiple(iface, impl);
    }

    public void multiple(Class iface, Class impl, Flavour flavour) {
        registry.multiple(iface, impl, flavour);
    }

    public void instance(Class iface, Object ref, Flavour flavour) {
        registry.instance(iface, ref, flavour);
    }

    public void instance(Class iface, Object ref) {
        registry.instance(iface, ref);
    }
}
