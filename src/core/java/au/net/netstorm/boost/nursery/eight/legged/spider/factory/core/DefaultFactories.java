package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.ConcreteFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultFactories implements Factories {
    private final List<Factory> factories = new ArrayList<Factory>();
    // FIX 2394 this is the bootstrap-bootstrap, if i can unwind NuImpl, i should be able move this to Bootstrapper
    {
        add(new ConcreteFactory());
    }

    public Factory find(InjectionSite site) {
        // FIX 2394 MAG toArray then reverse()?
        // FIX 2394 MH if it is just to elliminate reverse iteration, i would prefer to add in right order
        // FIX 2394 MH this would be done using LinkedList.addFirst()
        int size = factories.size();
        for (int i = size - 1; i >= 0; i--) {
            Factory factory = factories.get(i);
            if (factory.canHandle(site)) return factory;
        }
        throw new UnresolvableException(site);
    }

    public void add(Factory factory) {
        // FIX 2394 should be a StrictXXX - fail on nulls and dups
        if (factory == null) throw new IllegalArgumentException("Factory can't be null.");
        if (factories.contains(factory)) throw new IllegalArgumentException("Factory already exists.");
        factories.add(factory);
    }
}
