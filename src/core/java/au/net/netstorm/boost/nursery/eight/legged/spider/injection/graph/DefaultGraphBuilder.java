package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ImplProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.InjectableInstanceProvider;

// FIX 2394 split
// FIX 2394 MAG gotta be some dupe in here.
public final class DefaultGraphBuilder implements GraphBuilder {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final InjectionWeb web;

    public DefaultGraphBuilder(InjectionWeb web) {
        this.web = web;
    }

    public <T> InjectionGraph<T> resolve(Class<T> root, InjectionType type) {
        InjectionSite site = builder.root(type);
        Injection injection = web.injection(site);
        return new DefaultInjectionGraph<T>(root, injection);
    }

    // FIX 2395 where is it enforced that root is an interface
    public <T> InjectionGraph<T> nu(Class<T> root, InjectionType type, Object... args) {
        InjectionSite site = builder.root(type);
        Provider provider = web.provider(site);
        return graph(root, site, provider, args);
    }

    public <T> InjectionGraph<T> inject(Class<T> root, InjectionType type, Object instance) {
        InjectionSite site = builder.root(type);
        Provider provider = new InjectableInstanceProvider(instance);
        return graph(root, site, provider);
    }

    // FIX 2394 names - root - is sometimes an impl, sometimes an iface for this class.
    // FIX 2394 nuImpl - root=impl, nu - root=iface
    // FIX 2394 make root a strong type. DefaultImplementation.
    public <T> InjectionGraph<T> nuImpl(Class<T> root, InjectionType type, Object... args) {
        InjectionSite site = builder.root(type);
        Implementation impl = new DefaultImplementation(root);
        Provider provider = new ImplProvider(impl);
        return graph(root, site, provider, args);
    }

    private <T> InjectionGraph<T> graph(Class<T> root, InjectionSite site, Provider provider, Object... args) {
        Injection injection = new ProvidedInjection(web, site, provider, args);
        return new DefaultInjectionGraph<T>(root, injection);
    }
}
