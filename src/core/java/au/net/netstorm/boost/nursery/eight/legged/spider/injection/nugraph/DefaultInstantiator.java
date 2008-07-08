package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import java.util.Set;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultInstantiator implements Instantiator {
    public void instantiate(Providers providers, Instances instances) {
        Set<InjectionSite> keys = providers.keySet();
        // FIX 2394 this sucks, why the hell do arrays not implement iterable.
        InjectionSite[] sites = keys.toArray(new InjectionSite[keys.size()]);
        instantiate(providers, instances, sites);
    }

    public void instantiate(Providers providers, Instances instances, InjectionSite[] sites) {
        for (InjectionSite site : sites) {
            instantiate(providers, instances, site);
        }
    }

    private void instantiate(Providers providers, Instances instances, InjectionSite site) {
        Provider provider = providers.get(site);
        Creator<InjectionSite, Object> creator = new InstanceCreator(providers, provider, instances);
        instances.get(site, creator);
    }
}
