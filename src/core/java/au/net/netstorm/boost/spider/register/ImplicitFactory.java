package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.gunge.impl.ImplMaster;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.linkage.Linkage;
import static au.net.netstorm.boost.spider.register.Stamp.SINGLE;

public final class ImplicitFactory implements Factory {
    private static final Object[] NO_PARAMS = {};
    private final ImplMaster impler;

    public ImplicitFactory(ImplMaster impler) {
        this.impler = impler;
    }

    public Blueprint get(Linkage linkage) {
        Interface iface = linkage.getIface();
        Implementation impl = impler.impl(iface);
        return new DefaultBlueprint(SINGLE, impl, NO_PARAMS);
    }

    public boolean canHandle(Linkage linkage) {
        Interface iface = linkage.getIface();
        return impler.hasImpl(iface);
    }
}
