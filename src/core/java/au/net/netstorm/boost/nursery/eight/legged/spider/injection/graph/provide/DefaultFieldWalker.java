package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.gunge.type.DefaultMarker;
import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.HasInjectableTarget;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldMaster;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldMaster;

// FIX 2394 Clean this beast. Check out ConstructorWalker. Use ProviderOperations.
// DEBT ParameterNumber {
public final class DefaultFieldWalker implements Walker {
    private final ProviderOperations opererations = new DefaultProviderOperations();
    private final Marker marker = new DefaultMarker();
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final ResolvableFieldMaster resolvable = new DefaultResolvableFieldMaster();

    public void traverse(SiteWalker walker, Node node, SiteState state, InjectionSite site, Provider provider) {
        Provider root = opererations.root(provider);
        if (!marker.is(root, HasInjectableTarget.class)) return;
        HasInjectableTarget injectable = (HasInjectableTarget) root;
        Class<?> target = injectable.getTargetClass();
        InjectionSite[] sites = sites(target);
        walker.traverse(node, state, site, sites);
    }

    private InjectionSite[] sites(Class<?> target) {
        List<InjectionSite> sites = new ArrayList<InjectionSite>();
        // FIX 2394 do we want to support inheritance?
        for (Field f : target.getDeclaredFields()) {
            if (resolvable.isResolvableField(f)) {
                addSite(sites, f);
            }
        }
        return sites.toArray(new InjectionSite[sites.size()]);
    }

    private void addSite(List<InjectionSite> sites, Field f) {
        InjectionSite site = builder.fields(f);
        sites.add(site);
    }
}
// } DEBT ParameterNumber