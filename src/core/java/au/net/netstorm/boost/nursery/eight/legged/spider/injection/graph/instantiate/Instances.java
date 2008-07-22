package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. to be used in Instantiator/InstanceCreator.
public interface Instances extends Iterable<InjectionSite> {
    // FIX 2394 suxor. but args for nu can be null.
    // FIX 2394 Try new Optional code instead.
    Object NULL = new Object();

    Object get(InjectionSite site);

    // FIX 2394 is there anyway to prevent the creator from leaking?
    Object get(InjectionSite site, Creator<InjectionSite, Object> creator);

    void put(InjectionSite site, Object arg);

    void replace(InjectionSite site, Object ref);
}
