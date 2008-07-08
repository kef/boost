package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.gunge.collection.Creator;

// FIX 2394 use or lose. to be used in Instantiator/InstanceCreator.
public final class DefaultInstances implements Instances {
    // FIX 2394 strong type for instance?
    public void put(InjectionSite site, Object instance) {
        throw new UnsupportedOperationException();
    }

    public Object get(InjectionSite site) {
        throw new UnsupportedOperationException();
    }

    public void get(InjectionSite site, Creator<InjectionSite, Object> creator) {
        throw new UnsupportedOperationException();
    }
}
