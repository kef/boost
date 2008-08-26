package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.protocol;

import au.net.netstorm.boost.gunge.optional.Optional;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultProvidersWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.ProvidersWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultProtocolInstanceWirer implements ProtocolInstanceWirer {
    private final ProvidersWirer wirer;
    private final Protocol graph;
    private final Resolver resolver;

    public DefaultProtocolInstanceWirer(FactoryResolver factories, AspectResolver aspector, Resolver resolver) {
        this.resolver = resolver;
        this.graph = graph(aspector);
        this.wirer = new DefaultProvidersWirer(factories);
    }

    public ProtocolInstance nu(InjectionSite root, Optional<Provider> provider, Object[] args) {
        Providers providers = wirer.nu(provider, root, args);
        Instances instances = new DefaultInstances(providers);
        return new DefaultProtocolInstance(graph, providers, instances, root, resolver);
    }

    private Protocol graph(AspectResolver aspector) {
        ProtocolWirer wirer = new DefaultProtocolWirer(aspector);
        return wirer.nu();
    }
}
