package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjector;

// FIX BREADCRUMB 2328 driving me up
// FIX 2394 could probably be split into ctor and field injections
public final class DefaultInjection implements PhasedInjection {
    private Provider provider;
    private ConstructorInjector ctorInjector;
    private FieldInjector[] fieldInjectors;

    public void build(InjectionContext context) {

    }

    public Object apply() {
        Object instance = ctorInjector.inject();
        for (FieldInjector injector : fieldInjectors) injector.inject(instance);
        return instance;
    }
}
