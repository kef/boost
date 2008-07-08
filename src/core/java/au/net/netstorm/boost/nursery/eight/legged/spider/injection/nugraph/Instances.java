package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.gunge.collection.Creator;

// FIX 2394 use or lose. to be used in Instantiator/InstanceCreator.
public interface Instances {
    // FIX 2394 strong type for instance?
    void put(InjectionSite site, Object instance);

    Object get(InjectionSite site);

    void get(InjectionSite site, Creator<InjectionSite, Object> creator);
}
