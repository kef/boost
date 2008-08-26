package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.data.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;

// DEBT ParameterNumber {
public final class DefaultConstructorWalker implements Walker {
    private final ProviderOperations opererations = new DefaultProviderOperations();

    public void traverse(SiteWalker walker, Node node, SiteState state, InjectionSite site, Provider provider) {
        InjectionSite[] sites = opererations.constructors(site, provider);
        walker.traverse(node, state, site, sites);
    }
}
// } DEBT ParameterNumber