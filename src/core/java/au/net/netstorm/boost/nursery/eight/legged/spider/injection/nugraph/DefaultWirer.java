package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultWirer implements Wirer {
    public void wire(Instances instances, Resolvables resolvables) {
        for (Resolvable resolvable : resolvables) {
            wire(instances, resolvable);
        }
    }

    private void wire(Instances instances, Resolvable resolvable) {
        Object host = host(instances, resolvable);
        InjectionSite[] sites = resolvable.sites();
        wire(instances, host, sites);
    }

    private void wire(Instances instances, Object host, InjectionSite[] sites) {
        for (InjectionSite site : sites) {
            wire(instances, host, site);
        }
    }

    private void wire(Instances instances, Object host, InjectionSite site) {
        Failer<InjectionSite> failer = new ResolutionFailer();
        Object instance = instances.get(site, failer);
        site.inject(host, instance);
    }

    private Object host(Instances instances, Resolvable resolvable) {
        InjectionSite host = resolvable.host();
        return instances.get(host);
    }
}
