package au.net.netstorm.boost.nursery.eight.legged.spider.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.guts.InjectionContext;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;

// FIX 2328 injection graph node, does the actual injection using a provider
public interface Injection {
    void build(); 
    ResolvedInstance apply(InjectionContext ctx);
}
