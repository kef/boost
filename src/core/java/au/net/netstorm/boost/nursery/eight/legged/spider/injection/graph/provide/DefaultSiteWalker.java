package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.UnresolvableException;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;

public final class DefaultSiteWalker implements SiteWalker {
    private final Walker constructor = new DefaultConstructorWalker();
    private final Walker fields = new DefaultFieldWalker();
    private final ProviderOperations operations = new DefaultProviderOperations();
    private final Providers providers;
    private final Resolvables resolvables;

    public DefaultSiteWalker(Providers providers, Resolvables resolvables) {
        this.providers = providers;
        this.resolvables = resolvables;
    }

    public void traverse(InjectionSite site) {
        SiteState state = new DefaultSiteState();
        traverse(state, site);
    }

    public void traverse(SiteState state, InjectionSite site) {
        if (state.hasWalked(site)) return;
        state.walking(site);
        safeTraverse(state, site);
    }

    public void traverse(SiteState state, InjectionSite host, InjectionSite[] sites) {
        resolvables.add(host, sites);
        for (InjectionSite site : sites) traverse(state, site);
    }

    private void safeTraverse(SiteState state, InjectionSite site) {
        try {
            unsafeTraverse(state, site);
        } catch (UnresolvableException ignore) {
            // FIX 2394 fix this crud. no obvious way around it. basically don't care at this stage if it can't provide
            // FIX 2394 this gets validated in next phase (could be created by constructor/initializer)
        }
    }

    private void unsafeTraverse(SiteState state, InjectionSite site) {
        // FIX BREADCRUMB 2394 aaaaaaaaaaaaaaaaa now. why is this saying it can provide for things like class[]
        // FIX BREADCRUMB 2394 bbbbbbbbbbbbbbbbb at a guess, i am thinking that concrete factory, trying it now.
        Provider provider = providers.provide(site);
        Provider root = operations.root(provider);
        constructor.traverse(this, state, site, root);
        fields.traverse(this, state, site, root);
    }
}
