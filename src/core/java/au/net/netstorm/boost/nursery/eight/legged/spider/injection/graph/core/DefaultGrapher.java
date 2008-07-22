package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.gunge.optional.DefaultOptional;
import au.net.netstorm.boost.gunge.optional.NotSet;
import au.net.netstorm.boost.gunge.optional.Optional;
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
        Optional<Provider> optional = new NotSet<Provider>();
        Object instance = enforcer.apply(type, optional, args);
        return cast(type, instance);
    }

    public <T> T graph(InjectionType<T> type, Provider provider) {
        Optional<Provider> optional = new DefaultOptional<Provider>(provider);
        Object instance = enforcer.apply(type, optional);
        return cast(type, instance);
    }

    private <T> T cast(InjectionType<T> type, Object instance) {
        Class<T> cls = type.rawClass();
        return cls.cast(instance);
    }

    private GraphLifecycleEnforcer enforcer(FactoryResolver resolver, AspectResolver aspector) {
        GraphWirer wirer = new DefaultGraphWirer(resolver, aspector);
        return new DefaultGraphLifecycleEnforcer(wirer);
    }
}
