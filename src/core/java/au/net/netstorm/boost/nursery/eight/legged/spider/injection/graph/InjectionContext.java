package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

// FIX 2328 state used to build object graph
public interface InjectionContext {
    Provider provider(InjectionSite site);

    Injection injection(InjectionSite site);
}
