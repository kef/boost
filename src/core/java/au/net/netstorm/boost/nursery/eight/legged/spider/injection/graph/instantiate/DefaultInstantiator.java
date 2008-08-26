package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import java.util.Arrays;
import java.util.List;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 this one should dissapear.
public final class DefaultInstantiator implements Instantiator {
    private Creator<InjectionSite, Object> creator;

    public DefaultInstantiator(Creator<InjectionSite, Object> creator) {
        this.creator = creator;
    }

    public void instantiate(Providers providers, Instances instances) {
        instantiate(providers, instances, providers);
    }

    public void instantiate(Providers providers, Instances instances, InjectionSite[] sites) {
        List<InjectionSite> list = Arrays.asList(sites);
        instantiate(providers, instances, list);
    }

    private void instantiate(Providers providers, Instances instances, Iterable<InjectionSite> list) {
        for (InjectionSite site : list) {
            // FIX 2394 EX checkout possible failures from this guy. 
            instantiate(providers, instances, site);
        }
    }

    private void instantiate(Providers providers, Instances instances, InjectionSite site) {
        instances.get(site, creator);
    }
}
