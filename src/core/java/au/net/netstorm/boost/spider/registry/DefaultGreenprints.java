package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultGreenprints implements Greenprints {
    private final Greenprints[] layers;

    public DefaultGreenprints(Greenprints[] layers) {
        this.layers = layers;
    }

    public Blueprint get(Interface iface, Flavour flavour) {
        return layers[0].get(iface, flavour);
    }

    public boolean exists(Interface iface, Flavour flavour) {
        return layers[0].exists(iface, flavour);
    }
}
