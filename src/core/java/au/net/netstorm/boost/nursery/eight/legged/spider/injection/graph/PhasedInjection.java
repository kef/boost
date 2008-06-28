package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;

public interface PhasedInjection extends Injection {
    void build(InjectionWeb context);
}
