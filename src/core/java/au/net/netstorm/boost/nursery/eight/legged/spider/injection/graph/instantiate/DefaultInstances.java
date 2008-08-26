package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.ResolutionFailer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultInstances extends Primordial implements Instances {
    private final ResolutionFailer failer = new ResolutionFailer();
    private final IntegrityMap<InjectionSite, Object> instances = new DefaultIntegrityMap<InjectionSite, Object>();
    private final List todo = new LinkedList();
    private final Creator<InjectionSite, Object> creator;

    public DefaultInstances(Providers providers) {
        creator = new InstanceCreator(providers, this, todo);
    }

    public Object get(InjectionSite site) {
        return instances.get(site, failer);
    }

    // FIX 2394 name. differentiate between bang and create.
    public Object getXXX(InjectionSite site) {
        return instances.get(site, creator);
    }

    public void put(InjectionSite site, Object ref) {
        instances.put(site, ref);
    }

    public void replace(InjectionSite site, Object ref) {
        instances.replace(site, ref);
    }

    // FIX 2394 make this stronger.
    public List inOrder() {
        return todo;
    }

    public Iterator<InjectionSite> iterator() {
        return instances.iterator();
    }
}
