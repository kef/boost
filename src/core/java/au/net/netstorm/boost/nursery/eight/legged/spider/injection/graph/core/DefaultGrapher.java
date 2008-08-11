package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.gunge.optional.DefaultOptional;
import au.net.netstorm.boost.gunge.optional.NotSet;
import au.net.netstorm.boost.gunge.optional.Optional;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.DefaultResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.spider.resolve.Resolver;

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

    // FIX 2394 use or lose type param. It is required for type safetey, 
    // FIX 2394 but need to rethink how to process NuImpl with aspects.
    private <T> T cast(InjectionType<T> type, Object instance) {
        // FIX 2394 buggy. the strong cast breaks nuImpl if the impl is proxied.
        // FIX 2394 should check for aspectorization or make people pass in iface which may be better.
//        Class<T> cls = type.rawClass();
//        return cls.cast(instance);
        return (T) instance;
    }

    private GraphLifecycleEnforcer enforcer(FactoryResolver factories, AspectResolver aspector) {
        // FIX 2394 this is a nasty hack. Need to come up with a more consist approach to exposing the spider to itself.
        Resolver resolver = new DefaultResolver(this);
        GraphWirer wirer = new DefaultGraphWirer(factories, aspector, resolver);
        return new DefaultGraphLifecycleEnforcer(wirer);
    }
}
