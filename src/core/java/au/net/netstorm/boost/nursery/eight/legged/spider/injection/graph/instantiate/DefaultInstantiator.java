package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import java.util.Arrays;
import java.util.List;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultInstantiator implements Instantiator {
    public void instantiate(Providers providers, Instances instances) {
        instantiate(providers, instances, providers);
    }

    public void instantiate(Providers providers, Instances instances, InjectionSite[] sites) {
        List<InjectionSite> list = Arrays.asList(sites);
        instantiate(providers, instances, list);
    }

    private void instantiate(Providers providers, Instances instances, Iterable<InjectionSite> list) {
        for (InjectionSite site : list) {
            instantiate(providers, instances, site);
        }
    }

    private void instantiate(Providers providers, Instances instances, InjectionSite site) {
        Provider provider = providers.get(site);
        Creator<InjectionSite, Object> creator = new InstanceCreator(providers, provider, instances);
        instances.get(site, creator);
    }
}
