package au.net.netstorm.boost.nursery.eight.legged.spider.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.guts.InjectionContext;

// FIX 2328 injection graph node, does the actual injection using a provider
public interface InjectionGraph {
    void build(); 
    Object apply(InjectionContext ctx);
}
