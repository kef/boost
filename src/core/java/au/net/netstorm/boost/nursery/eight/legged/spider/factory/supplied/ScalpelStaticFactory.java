package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.StaticEdgeProvider;
import au.net.netstorm.boost.scalpel.core.Edge;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class ScalpelStaticFactory extends Primordial implements Factory {
    NuImpl nu;

    public Provider nu(InjectionSite site) {
        if (!canHandle(site)) throw new IllegalStateException();
        Class edge = raw(site);
        return nu.nu(StaticEdgeProvider.class, edge);
    }

    public boolean canHandle(InjectionSite site) {
        Class<?> cls = raw(site);
        String name = cls.getName();
        // FIX 2394 mmmm, i think this is in scapel some where
        return Edge.class.isAssignableFrom(cls) && name.endsWith("Static");
    }

    private Class<?> raw(InjectionSite site) {
        InjectionType type = site.type();
        return type.rawClass();
    }
}
