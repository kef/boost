package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultInstantiator implements Instantiator {
    public void instantiate(Providers providers, Instances instances, Iterable<InjectionSite> sites) {
        // FIX 2394 depenencies specify a partial ordering, real ordering is arbitrary
        for (InjectionSite site : sites) {
            instantiate(providers, instances, site);
        }
    }

    // FIX 2394 this dup sucks, why the hell do arrays not implement iterable.
    // FIX 2394 make an iterable array wrapper
    public void instantiate(Providers providers, Instances instances, InjectionSite[] sites) {
        for (InjectionSite site : sites) {
            instantiate(providers, instances, site);
        }
    }

    public void instantiate(Providers providers, Instances instances, InjectionSite site) {
        Provider provider = providers.get(site);
        Creator<InjectionSite, Object> creator = new InstanceCreator(providers, provider, instances);
        instances.get(site, creator);
    }

}
