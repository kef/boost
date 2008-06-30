package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.EdgeProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.StaticEdgeProvider;
import au.net.netstorm.boost.scalpel.core.Edge;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class ScalpelFactory implements Factory {
    NuImpl nu;

    public Provider nu(InjectionSite site) {
        if (!canHandle(site)) throw new IllegalStateException();
        Class edge = raw(site);
        Class<? extends Provider> provider = determineProvider(edge);
        return nu.nu(provider, edge);
    }

    public boolean canHandle(InjectionSite site) {
        Class<?> cls = raw(site);
        // FIX 2394 i think this is genericised in scalpel some where, if not it should be
        return Edge.class.isAssignableFrom(cls);
    }

    private Class<?> raw(InjectionSite site) {
        InjectionType type = site.type();
        return type.rawClass();
    }

    private Class<? extends Provider> determineProvider(Class edge) {
        String name = edge.getName();
        return name.endsWith("Static") ? StaticEdgeProvider.class : EdgeProvider.class;
    }
}
