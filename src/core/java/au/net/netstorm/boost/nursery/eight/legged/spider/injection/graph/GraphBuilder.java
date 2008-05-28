package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX 2328 creates an injection for an injection-site
public interface GraphBuilder {
    Injection build(InjectionType type);
}
