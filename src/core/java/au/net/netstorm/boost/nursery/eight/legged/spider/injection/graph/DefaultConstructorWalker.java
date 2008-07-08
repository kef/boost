package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
public final class DefaultConstructorWalker implements Walker {
    private final ProviderOperations opererations = new DefaultProviderOperations();

    public void traverse(SiteWalker walker, Graph state, InjectionSite site, Provider provider) {
        InjectionSite[] sites = opererations.constructors(site, provider);
        walker.traverse(state, site, sites);
    }
}
