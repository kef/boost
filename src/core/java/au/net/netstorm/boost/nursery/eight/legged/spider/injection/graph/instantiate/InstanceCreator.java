package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;

// FIX 2394 nasty. help me.
public final class InstanceCreator implements Creator<InjectionSite, Object> {
    private final Instantiator instantiator = new DefaultInstantiator();
    private final ProviderOperations operations = new DefaultProviderOperations();
    private Providers providers;
    private Provider provider;
    private Instances instances;

    public InstanceCreator(Providers providers, Provider provider, Instances instances) {
        this.providers = providers;
        this.provider = provider;
        this.instances = instances;
    }

    public Object apply(InjectionSite site) {
        Object[] args = args(providers, provider, instances, site);
        return provider.nu(args);
    }

    private Object[] args(Providers providers, Provider provider, Instances instances, InjectionSite site) {
        InjectionSite[] sites = operations.constructors(site, provider);
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
}
