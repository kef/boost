package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;

// FIX 2394 use or lose.
// FIX BREADCRUMB 2394 building up a cleaner graph construction lifecycle: build graph/instantiate/resolve/post-process
// FIX 2394 acts as a future for each stage to publish to, and the next phase can grap from it
public interface Injections {
    // FIX 2394 i am pretty unhappy with the names of the units of work, instead of ConstructorInjector etc.
    // FIX 2394 maybe have Instantiator, Resolver, PostProcessor
    void instantiate(Injection injection, ConstructorInjector constructor);

    void resolve(Injection injection, MemberInjector resolver);

    void post(Injection injection, PostProcess proccess);
}
