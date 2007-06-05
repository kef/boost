package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFlavouredMap implements FlavouredMap {
    private final FlavouredMapEngine engine;

    public DefaultFlavouredMap(FlavouredMapEngine engine) {
        this.engine = engine;
    }

    public void put(Interface iface, Flavour flavour, Object thing) {
        FlavouredInterface flavoured = flavoured(iface, flavour);
        engine.put(flavoured, thing);
    }

    public Object get(Interface iface, Flavour flavour) {
        FlavouredInterface flavoured = flavoured(iface, flavour);
        return engine.get(flavoured);
    }

    public boolean exists(Interface iface, Flavour flavour) {
        FlavouredInterface flavoured = flavoured(iface, flavour);
        return engine.exists(flavoured);
    }

    private FlavouredInterface flavoured(Interface iface, Flavour flavour) {
        return new DefaultFlavouredInterface(iface, flavour);
    }
}
