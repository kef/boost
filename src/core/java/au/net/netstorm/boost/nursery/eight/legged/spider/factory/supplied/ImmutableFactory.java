package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ImmutableProvider;

// FIX 2394 I have pushed this into the spider for now. Review.
public final class ImmutableFactory implements Factory {
    NuImpl impl;

    public Provider nu(InjectionSite site) {
        if (!canHandle(site)) throw new IllegalStateException();
        Class raw = raw(site);
        Interface iface = new DefaultInterface(raw);
        return impl.nu(ImmutableProvider.class, iface);
    }

    public boolean canHandle(InjectionSite site) {
        Class<?> cls = raw(site);
        return Data.class.isAssignableFrom(cls);
    }

    private Class<?> raw(InjectionSite site) {
        InjectionType type = site.type();
        return type.rawClass();
    }
}
