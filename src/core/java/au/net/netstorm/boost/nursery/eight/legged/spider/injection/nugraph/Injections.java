package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose.
// FIX BREADCRUMB 2394 building up a cleaner graph construction lifecycle: build graph/instantiate/resolve/post-process
// FIX 2394 acts as a future for each stage to publish to, and the next phase can grap from it

// FIX 2394 split into readable/writable
public interface Injections {
    // FIX 2394 i am pretty unhappy with the names of the units of work, instead of ConstructorInjector etc.
    // FIX 2394 maybe have Instantiator, Resolver, PostProcessor
    void instantiate(InjectionSite injection, Instantiator constructor);

    void resolve(InjectionSite injection, Resolver resolver);

    void post(InjectionSite injection, PostProcessor postprocessor);

    Provider provide(InjectionSite site);
}
