package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.nursery.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;

import java.util.ArrayList;
import java.util.List;

public final class DefaultFactories implements Factories {
    private final List factories = new ArrayList();

    public Factory find(Linkage linkage) {
        int size = factories.size();
        for (int i = size - 1; i >= 0; i--) {
            Factory factory = (Factory) factories.get(i);
            if (factory.canHandle(linkage)) return factory;
        }
        throw new CannotProvideException(linkage);
    }

    public void add(Factory factory) {
        factories.add(factory);
    }
}
