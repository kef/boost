package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionContext;

public interface MemberInjector {
    void inject(InjectionContext context, Object instance);
}
