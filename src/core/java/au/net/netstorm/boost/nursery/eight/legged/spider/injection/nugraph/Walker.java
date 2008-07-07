package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
public interface Walker {
    void traverse(SiteWalker walker, Graph state, InjectionSite site, Provider provider);
}
