package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// DEBT ParameterNumber {
public interface Walker {
    void traverse(SiteWalker walker, Node node, SiteState state, InjectionSite site, Provider provider);
}
// } DEBT ParameterNumber