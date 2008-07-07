package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. building parrallel implementation for better graph builder.
public final class DefaultGraphState implements GraphState {
    public Provider provide(InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
