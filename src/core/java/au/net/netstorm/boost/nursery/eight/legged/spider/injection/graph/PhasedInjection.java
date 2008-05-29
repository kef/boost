package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;

// FIX 2328 injection graph node, does the actual injection using a provider
public interface PhasedInjection extends Injection {
    void build(InjectionWeb context);
}
