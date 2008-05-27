package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

// FIX BREADCRUMB 2328 driving me up
// FIX 2394 could probably be split into ctor and field injections
public final class DefaultInjection implements Injection {
    private Provider provider;
    private Injection[] ctorInjections;
    private Injection[] fieldInjections;

    public void build() {
        ctorInjections = new Injection[0];
        fieldInjections = new Injection[0];
    }

    public Object apply(InjectionContext ctx) {
//        Object[] args = construction(ctx);
//        Object instance = provider.nu(args);
//        // FIX BREADCRUMB 2394 do field injections
//        return instance;
        return null;
    }

    private Object[] construction(InjectionContext ctx) {
        Object[] args = new Object[ctorInjections.length];
        for (int i = 0; i < ctorInjections.length; i++) {
            Injection injection = ctorInjections[i];
            args[i] = injection.apply(ctx);
        }
        return args;
    }
}
