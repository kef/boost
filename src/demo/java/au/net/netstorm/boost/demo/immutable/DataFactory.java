package au.net.netstorm.boost.demo.immutable;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

// FIX 2130 Move into "core"?
public final class DataFactory implements Factory {
    NuImpl impl;

    public Provider nu(InjectionSite site) {
        if (!canHandle(site)) throw new IllegalStateException();
        Class raw = raw(site);
        return impl.nu(DataProvider.class, raw);
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
