package au.net.netstorm.boost.spider.registry;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFactories implements Factories {
    private final List factories = new ArrayList();

    public ResolvedInstance get(Interface iface, ImplementationRef host, ProviderEngine provider, Instances instances) {
        int size = factories.size();
        for (int i = size - 1; i >= 0; i--) {
            Factory factory = (Factory) factories.get(i);
            boolean canHandle = factory.canHandle(iface);
            if (canHandle) return factory.get(iface, host, provider, instances);
        }
        throw new CannotProvideException(iface);
    }

    public void add(Factory factory) {
        factories.add(factory);
    }
}
