package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Interface;

import java.util.ArrayList;
import java.util.List;

public final class DefaultFactories implements Factories {
    private final List factories = new ArrayList();

    public Factory find(Interface iface) {
        int size = factories.size();
        for (int i = size - 1; i >= 0; i--) {
            Factory factory = (Factory) factories.get(i);
            if (factory.canHandle(iface)) return factory;
        }
        throw new CannotProvideException(iface);
    }

    public void add(Factory factory) {
        factories.add(factory);
    }
}
