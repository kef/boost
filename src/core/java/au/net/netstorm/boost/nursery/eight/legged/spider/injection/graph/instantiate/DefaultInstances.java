package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import java.util.Iterator;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.ResolutionFailer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultInstances implements Instances {
    private final ResolutionFailer failer = new ResolutionFailer();
    private final IntegrityMap<InjectionSite, Object> instances = new DefaultIntegrityMap<InjectionSite, Object>();

    public Object get(InjectionSite site) {
        return instances.get(site, failer);
    }

    public Object get(InjectionSite site, Creator<InjectionSite, Object> creator) {
        return instances.get(site, creator);
    }

    public void put(InjectionSite site, Object ref) {
        instances.put(site, ref);
    }

    public void replace(InjectionSite site, Object ref) {
        instances.replace(site, ref);
    }

    public Iterator<InjectionSite> iterator() {
        return instances.iterator();
    }
}
