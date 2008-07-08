package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.Failer;

// FIX 2394 use or lose. to be used in Instantiator/InstanceCreator.
public interface Instances {
    // FIX 2394 suxor. but args for nu can be null.
    Object NULL = new Object();

    Object get(InjectionSite site);

    Object get(InjectionSite site, Creator<InjectionSite, Object> creator);

    Object get(InjectionSite site, Failer<InjectionSite> failer);

    void put(InjectionSite site, Object arg);
}
