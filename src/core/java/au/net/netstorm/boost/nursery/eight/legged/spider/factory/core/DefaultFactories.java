package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultFactories implements Factories {
    private static final int FIRST = 0;
    // FIX 2394 badness. wrong data structure. really after a strict(no-dupes)-reverse-entry-ordered list :)
    private final List<Factory> factories = new ArrayList<Factory>();

    public Factory find(InjectionSite site) {
        for (Factory factory : factories) {
            if (factory.canHandle(site)) return factory;
        }
        throw new UnresolvableException(site);
    }

    public void add(Factory factory) {
        // FIX 2394 wrong ds.
        if (factory == null) throw new IllegalArgumentException("Factory can not be null.");
        if (factories.contains(factory)) throw new IllegalArgumentException("Factory already exists.");
        factories.add(FIRST, factory);
    }
}
