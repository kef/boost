package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.DefaultBlueprint;
import au.net.netstorm.boost.spider.registry.Greenprints;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class LazyGreenprints implements Greenprints {
    private static final Stamp SINGLE = Stamp.SINGLE;
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private final ImplMaster impler = new DefaultImplMaster();

    public Blueprint get(Interface iface, Flavour flavour) {
        Implementation impl = impler.defaultImpl(iface);
        return blueprint(impl);
    }

    public boolean exists(Interface iface, Flavour flavour) {
        return impler.hasDefaultImpl(iface);
    }

    private Blueprint blueprint(Implementation impl) {
        return new DefaultBlueprint(SINGLE, impl, UNFLAVOURED);
    }
}