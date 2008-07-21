package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. to be used in Instantiator/InstanceCreator.
public final class DefaultInstances implements Instances {
    private final IntegrityMap<InjectionSite, Object> instances = new DefaultIntegrityMap<InjectionSite, Object>();

    // FIX 2394 should this always be get(site, failer), if so, the failer can be internal to instances. nice.
    public Object get(InjectionSite site) {
        return instances.get(site);
    }

    public Object get(InjectionSite site, Creator<InjectionSite, Object> creator) {
        return instances.get(site, creator);
    }

    public Object get(InjectionSite site, Failer<InjectionSite> failer) {
        return instances.get(site, failer);
    }

    public void put(InjectionSite site, Object arg) {
        instances.put(site, arg);
    }
}
