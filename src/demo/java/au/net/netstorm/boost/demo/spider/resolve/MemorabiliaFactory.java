package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.ImplementationRef;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class MemorabiliaFactory implements Factory {
    private static final Interface MEMORABILIA = new DefaultInterface(Memorabilia.class);

    public ResolvedInstance get(Interface iface, ImplementationRef host, ProviderEngine provider, Instances instances) {
        Implementation hostImpl = host.get();
        Class hostClass = hostImpl.getImpl();
        Memorabilia memorabilia = new StolenMemorabilia(hostClass);
        return new DefaultBaseReference(memorabilia);
    }

    public boolean canHandle(Interface iface) {
        return MEMORABILIA.equals(iface);
    }
}
