package au.net.netstorm.boost.spider.registry;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.spider.linkage.Linkage;

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
