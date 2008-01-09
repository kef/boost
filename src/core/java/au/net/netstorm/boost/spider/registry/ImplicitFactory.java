package au.net.netstorm.boost.spider.registry;

import static au.net.netstorm.boost.spider.registry.Stamp.SINGLE;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class ImplicitFactory implements Factory {
    private static final Object[] NO_PARAMS = {};
    private final ImplMaster impler;

    public ImplicitFactory(ImplMaster impler) {
        this.impler = impler;
    }

    public Blueprint get(Implementation host, Interface iface) {
        Implementation impl = impler.impl(iface);
        return new DefaultBlueprint(SINGLE, impl, NO_PARAMS);
    }

    public boolean canHandle(Interface iface) {
        return impler.hasImpl(iface);
    }
}
