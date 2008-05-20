package au.net.netstorm.boost.nursery.eight.legged.spider.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.guts.InjectionContext;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.core.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.core.EdgeProvider;

// FIX BREADCRUMB 2328 driving me up
public final class DefaultInjection implements Injection {
    private Provider provider;
    private Injection[] children;

    public void build() {
        // FIX BREADCRUMB 2328 build real injection list
        children = new Injection[0];
        provider = new EdgeProvider();
    }

    public Object apply(InjectionContext ctx) {
        Object[] args = new Object[children.length];
        for (int i = 0; i < children.length; ++i) {
            args[i] = children[i].apply(ctx);
        }
        return provider.nu(args);
    }
}
