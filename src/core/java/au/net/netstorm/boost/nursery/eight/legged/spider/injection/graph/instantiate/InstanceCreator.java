package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import java.util.List;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;

// FIX 2394 nasty. help me.
public final class InstanceCreator implements Creator<InjectionSite, Object> {
    private final Instantiator instantiator = new DefaultInstantiator(this);
    private final ProviderOperations operations = new DefaultProviderOperations();
    private final Providers providers;
    private final Instances instances;
    // FIX BREADCRUMB 2394 aaaaaaaaaaaaaaaaa working on pushing through a state for target instances.
    private final List todo;

    public InstanceCreator(Providers providers, Instances instances, List todo) {
        this.providers = providers;
        this.instances = instances;
        this.todo = todo;
    }

    public Object apply(InjectionSite site) {
        Provider provider = providers.provide(site);
        Object[] args = args(site, provider);
        Object ref = provider.nu(args);
        todo.add(ref);
        return ref;
    }

    private Object[] args(InjectionSite site, Provider provider) {
        InjectionSite[] sites = operations.constructors(site, provider);
        // FIX 2394 does not gracefully handle cyclic dependencies on ctor args
        instantiator.instantiate(providers, instances, sites);
        return args(sites);
    }

    private Object[] args(InjectionSite[] sites) {
        Object[] args = new Object[sites.length];
        for (int i = 0; i < sites.length; i++) {
            InjectionSite s = sites[i];
            args[i] = instances.get(s);
        }
        return args;
    }
}
