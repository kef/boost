package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;

public interface GraphWirer {
    Graph wire(FactoryResolver resolver, AspectResolver aspector, InjectionSite root, Object... args);
}
