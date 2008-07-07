package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose.
public final class DefaultInjections implements Injections {
    // FIX 2394 i am pretty unhappy with the names of the units of work, instead of ConstructorInjector etc.
    // FIX 2394 maybe have Instantiator, Resolver, PostProcessor
    public void instantiate(InjectionSite injection, Instantiator constructor) {
        throw new UnsupportedOperationException();
    }

    public void resolve(InjectionSite injection, Resolver resolver) {
        throw new UnsupportedOperationException();
    }

    public void post(InjectionSite injection, PostProcessor postprocessor) {
        throw new UnsupportedOperationException();
    }

    public Provider provide(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
