package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface GraphWirer {
    Graph wire(InjectionSite root, Object... args);
    Graph wire(InjectionSite root, Provider base);
}
