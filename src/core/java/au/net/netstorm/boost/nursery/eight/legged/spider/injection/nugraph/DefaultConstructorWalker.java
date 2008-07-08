package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import java.lang.reflect.Type;

import au.net.netstorm.boost.gunge.type.DefaultMarker;
import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.HasParameters;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
public final class DefaultConstructorWalker implements Walker {
    private final Marker marker = new DefaultMarker();
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();

    public void traverse(SiteWalker walker, Graph state, InjectionSite site, Provider provider) {
        if (!marker.is(provider, HasParameters.class)) return;
        HasParameters parameterized = (HasParameters) provider;
        Type[] types = parameterized.getParameterTypes();
        // FIX 2394 This looks suspicious, not sure that this is the correct site
        InjectionType type = site.type();
        Class<?> host = type.rawClass();
        InjectionSite[] sites = builder.build(host, types);
        walker.traverse(state, site, sites);
    }
}
