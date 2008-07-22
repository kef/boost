package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 names. StatefulGraph should be Graph. Graph should be Stateless Graph.
public interface StatefulGraphWirer {
    StatefulGraph wire(InjectionSite root, Provider provider, Object... args);
}
