package au.net.netstorm.boost.spider.registry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFactories implements Factories {
    private final List factories = new ArrayList();

    public DefaultFactories() {
    }

    public ResolvedInstance get(Interface iface, ImplementationRef host, ProviderEngine provider, Instances instances) {
        for (Iterator itr = factories.iterator(); itr.hasNext();) {
            Factory factory = (Factory) itr.next();
            boolean canHandle = factory.canHandle(iface);
            if (canHandle) return factory.get(iface, host, provider, instances);
        }
        throw new CannotProvideException(iface);
    }

    public void add(Factory factory) {
        factories.add(0, factory);
    }
}
