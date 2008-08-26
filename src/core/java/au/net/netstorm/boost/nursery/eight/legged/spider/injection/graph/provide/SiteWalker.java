package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;

public interface SiteWalker {
    Node traverse(InjectionSite site, Providers providers);
    
    void traverse(Node root, SiteState state, InjectionSite site);

    void traverse(Node node, SiteState state, InjectionSite host, InjectionSite[] sites);
}
