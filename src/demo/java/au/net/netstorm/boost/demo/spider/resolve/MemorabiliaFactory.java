package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.DefaultBlueprint;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.DefaultImplementation;

public final class MemorabiliaFactory implements Factory {
    private static final Interface MEMORABILIA = new DefaultInterface(Memorabilia.class);

    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Class cls = host.getImpl();
        Memorabilia memorabilia = new StolenMemorabilia(cls);
        return new DefaultBaseReference(memorabilia);
    }

    public Blueprint get(Interface iface, Implementation host) {
        Class cls = host.getImpl();
        Object[] args = {cls};
        DefaultImplementation impl = new DefaultImplementation(StolenMemorabilia.class);
        return new DefaultBlueprint(Stamp.MULTIPLE, impl, args);
    }

    public boolean canHandle(Interface iface) {
        return MEMORABILIA.equals(iface);
    }

    public boolean isSingle(Interface iface) {
        return false;
    }
}
