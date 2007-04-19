package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 1676 Test drive.  This triggers work on "compose".
public final class DefaultSpider implements Spider {
    private final Provider provider;
    private final Injector injector;
    private final ResolverEngine resolver;
    private final Registry registry;

    public DefaultSpider(Provider provider, Injector injector, ResolverEngine resolver, Registry registry) {
        this.provider = provider;
        this.injector = injector;
        this.resolver = resolver;
        this.registry = registry;
    }

    public Object provide(Class type, Object[] parameters) {
        return provider.provide(type, parameters);
    }

    public void inject(Object ref) {
        injector.inject(ref);
    }

    public ResolvedInstance resolve(Interface iface) {
        return resolver.resolve(iface);
    }

    public ResolvedInstance[] resolve(Interface[] ifaces) {
        return resolver.resolve(ifaces);
    }

    public ResolvedInstance resolve(Implementation impl) {
        return resolver.resolve(impl);
    }

    public void prototype(Class iface, Class impl) {
        registry.prototype(iface, impl);
    }

    public void instance(Class iface, Object ref) {
        registry.instance(iface, ref);
    }

    public Interface[] getKeys() {
        return registry.getKeys();
    }
}
