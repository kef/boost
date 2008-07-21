package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.DefaultAspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.gunge.collection.Creator;

// DEBT ClassDataAbstractionCoupling {
public final class DefaultGraphWirer implements GraphWirer {
    public Graph wire(FactoryResolver resolver, AspectResolver aspector, InjectionSite root, Object... args) {
        Providers providers = providers(resolver);
        return graph(aspector, root, providers, args);
    }

    public Graph wire(FactoryResolver resolver, AspectResolver aspector, InjectionSite root, Provider base) {
        Providers providers = providers(resolver);
        providers.put(root, base);
        return graph(aspector, root, providers);
    }

    private Providers providers(FactoryResolver resolver) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return new DefaultProviders(creator);
    }

    private Graph graph(AspectResolver aspector, InjectionSite root, Providers providers, Object... args) {
        Instances instances = new DefaultInstances();
        Aspectorizer aspectorizer = new DefaultAspectorizer(aspector);
        PostProcessor poster = new DefaultPostProcessor(aspectorizer);
        return args.length == 0
                ? new DefaultGraph(providers, instances, poster, root)
                : new ParameterizedGraph(providers, instances, poster, root, args);
    }
}
// } DEBT ClassDataAbstractionCoupling