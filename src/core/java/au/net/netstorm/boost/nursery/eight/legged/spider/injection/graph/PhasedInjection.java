package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;

// FIX 2395 split into ApplyInjection, BuildInjection and this guy composes the two.
public interface PhasedInjection extends Injection {
    void build(InjectionWeb context);
}
