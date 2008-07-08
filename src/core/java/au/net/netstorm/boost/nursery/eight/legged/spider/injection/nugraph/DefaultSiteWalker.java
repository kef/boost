package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.gunge.type.DefaultMarker;
import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DelegatingProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
public final class DefaultSiteWalker implements SiteWalker {
    private final Marker marker = new DefaultMarker();
    private final Walker constructor = new DefaultConstructorWalker();
    private final Walker fields = new DefaultFieldWalker();

    public void traverse(Graph state, InjectionSite[] sites) {
        for (InjectionSite site : sites) traverse(state, site);
    }

    public void traverse(Graph state, InjectionSite site) {
        Provider provider = state.provide(site);
        Provider root = root(provider);
        constructor.traverse(this, state, site, root);
        fields.traverse(this, state, site, root);
    }

    private Provider root(Provider provider) {
        return marker.is(provider, DelegatingProvider.class) ? delegate(provider) : provider;
    }

    private Provider delegate(Provider provider) {
        DelegatingProvider delegator = (DelegatingProvider) provider;
        return delegator.root();
    }
}
