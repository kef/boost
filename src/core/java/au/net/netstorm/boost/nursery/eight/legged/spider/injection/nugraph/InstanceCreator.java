package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import java.lang.reflect.Type;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.HasInjectableTarget;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.HasParameters;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DelegatingProvider;

// FIX 2394 nasty. help me.
public final class InstanceCreator implements Creator<InjectionSite, Object> {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();
    private final Instantiator instantiator = new DefaultInstantiator();
    private Providers providers;
    private Provider provider;
    private Instances instances;

    public InstanceCreator(Providers providers, Provider provider, Instances instances) {
        this.providers = providers;
        this.provider = provider;
        this.instances = instances;
    }

    public Object create(InjectionSite site) {
        Object[] args = args(providers, provider, instances, site);
        return provider.nu(args);
    }

    private Object[] args(Providers providers, Provider provider, Instances instances, InjectionSite site) {
        Provider actual = root(provider);
        Class host = host(site, provider);
        Type[] params = params(actual);
        InjectionSite[] sites = builder.build(host, params);
        // FIX 2394 does not gracefully handle cyclic dependencies on ctor args
        instantiator.instantiate(providers, instances, sites);
        return args(instances, sites);
    }

    private Object[] args(Instances instances, InjectionSite[] sites) {
        Object[] args = new Object[sites.length];
        for (int i = 0; i < sites.length; i++) {
            InjectionSite s = sites[i];
            args[i] = instances.get(s);
        }
        return args;
    }

    // FIX 2394 delete all this crud. should not be required if i can get the provider interface down.
    private Class host(InjectionSite site, Provider provider) {
        if (!(provider instanceof HasInjectableTarget)) return raw(site);
        HasInjectableTarget target = (HasInjectableTarget) provider;
        return target.getTargetClass();
    }

    private Class raw(InjectionSite site) {
        InjectionType type = site.type();
        return type.rawClass();
    }

    private Type[] params(Provider provider) {
        if (!(provider instanceof HasParameters)) return new Type[0];
        HasParameters parameterized = (HasParameters) provider;
        return parameterized.getParameterTypes();
    }

    private Provider root(Provider provider) {
        if (!(provider instanceof DelegatingProvider)) return provider;
        DelegatingProvider delegator = (DelegatingProvider) provider;
        return delegator.root();
    }
}
