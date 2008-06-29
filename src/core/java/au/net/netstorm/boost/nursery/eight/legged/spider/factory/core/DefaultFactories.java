package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import java.util.List;
import java.util.ArrayList;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultFactories implements Factories {
    private final List<Factory> factories = new ArrayList<Factory>();

    public Factory find(InjectionSite site) {
        for (Factory factory : factories) {
            if (factory.canHandle(site)) return factory;
        }
        throw new IllegalArgumentException("Can not provide for injection site: " + site);
    }

    public void add(Factory factory) {
        // FIX 2394 should be a StrictXXX - fail on nulls and dups
        if (factory == null) throw new IllegalArgumentException("Factory can't be null.");
        if (factories.contains(factory)) throw new IllegalArgumentException("Factory already exists.");
        factories.add(factory);
    }
}