package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.HasInjectableTarget;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldMaster;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldMaster;
import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.gunge.type.DefaultMarker;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
public final class DefaultFieldWalker implements Walker {
    private final Marker marker = new DefaultMarker();
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final ResolvableFieldMaster resolvable = new DefaultResolvableFieldMaster();

    public void traverse(SiteWalker walker, Graph state, InjectionSite site, Provider provider) {
        if (!marker.is(provider, HasInjectableTarget.class)) return;
        HasInjectableTarget injectable = (HasInjectableTarget) provider;
        Class<?> target = injectable.getTargetClass();
        InjectionSite[] sites = sites(target);
        walker.traverse(state, site, sites);
    }

    private InjectionSite[] sites(Class<?> target) {
        List<InjectionSite> sites = new ArrayList<InjectionSite>();
        for (Field f : target.getDeclaredFields()) {
            if (resolvable.isResolvableField(f)) addSite(sites, f);
        }
        return sites.toArray(new InjectionSite[sites.size()]);
    }

    private void addSite(List<InjectionSite> sites, Field f) {
        InjectionSite site = builder.fields(f);
        sites.add(site);
    }
}
