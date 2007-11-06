package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.DefaultStampedResolvedInstance;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.spider.registry.StampedResolvedInstance;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class MemorabiliaFactory implements Factory {
    private static final Interface MEMORABILIA = new DefaultInterface(Memorabilia.class);

    public StampedResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Class cls = host.getImpl();
        Memorabilia memorabilia = new StolenMemorabilia(cls);
        ResolvedInstance instance = new DefaultBaseReference(memorabilia);
        return new DefaultStampedResolvedInstance(instance, Stamp.MULTIPLE);
    }

    public boolean canHandle(Interface iface) {
        return MEMORABILIA.equals(iface);
    }
}
