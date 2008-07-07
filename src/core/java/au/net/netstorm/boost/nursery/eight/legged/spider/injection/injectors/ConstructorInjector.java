package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionContext;

// FIX 2394 should actually be behind a provider, this guys leaks everywhere without even trying
public interface ConstructorInjector {
    Object inject(InjectionContext context);
}
