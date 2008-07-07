package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;

// FIX 2394 use or lose.
// FIX BREADCRUMB 2394 building up a cleaner graph construction lifecycle: build graph/instantiate/resolve/post-process
// FIX 2394 acts as a future for each stage to publish to, and the next phase can grap from it
public interface InjectionWork {
    void instantiate(Injection injection, Provider provider);
    // FIX 2394 for updated approach MemberInjector is now a bad name
    void resolve(Injection injection, MemberInjector resolver);
    void post(Injection injection, PostProcess proccess);
}
