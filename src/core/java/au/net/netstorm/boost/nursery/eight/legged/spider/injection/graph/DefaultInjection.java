package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;

// FIX BREADCRUMB 2328 driving me up
public final class DefaultInjection implements Injection {
    private Provider provider;
    private Injection[] children;

    public void build() {
        // FIX BREADCRUMB 2328 build real injection list
    }

    public ResolvedInstance apply(InjectionContext ctx) {
        // FIX 2328 implement
        throw new UnsupportedOperationException();
    }
}
