package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultGrapher implements Grapher {
    private final GraphLifecycleEnforcer enforcer;

    public DefaultGrapher(FactoryResolver resolver, AspectResolver aspector) {
        enforcer = enforcer(resolver, aspector);
    }

    public <T> T graph(InjectionType<T> type, Object... args) {
        // FIX 2394 yuck. Optional<Provider>
        Object instance = enforcer.apply(type, null, args);
        return cast(type, instance);
    }

    public <T> T graph(InjectionType<T> type, Provider provider) {
        Object instance = enforcer.apply(type, provider);
        return cast(type, instance);
    }

    private <T> T cast(InjectionType<T> type, Object instance) {
        Class<T> cls = type.rawClass();
        return cls.cast(instance);
    }

    private GraphLifecycleEnforcer enforcer(FactoryResolver resolver, AspectResolver aspector) {
        StatefulGraphWirer wirer = new DefaultStatefulGraphWirer(resolver, aspector);
        return new DefaultGraphLifecycleEnforcer(wirer);
    }
}
