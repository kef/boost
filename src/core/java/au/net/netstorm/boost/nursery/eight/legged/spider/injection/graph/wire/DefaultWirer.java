package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire;

import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.ResolutionFailer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvable;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.FieldInjectionSite;
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

    // FIX 2394 badness.
    private void wire(Instances instances, Object host, InjectionSite site) {
        if (!(site instanceof FieldInjectionSite)) return;
        FieldInjectionSite field = (FieldInjectionSite) site;
        if (field.isWired(host)) return;
        Failer<InjectionSite> failer = new ResolutionFailer();
        Object instance = instances.get(site, failer);
        field.inject(host, instance);
    }

    private Object host(Instances instances, Resolvable resolvable) {
        InjectionSite host = resolvable.host();
        Object nullable = instances.get(host);
        return nullable != Instances.NULL ? nullable : null;
    }
}
