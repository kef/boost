package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;

public final class LayeredGreenprints implements Greenprints {
    private final Greenprints[] layers;

    public LayeredGreenprints(Greenprints[] layers) {
        this.layers = layers;
    }

    public Blueprint get(Interface iface, Flavour flavour) {
        // FIX 1914 Check none exist at all.
        int i = index(iface, flavour);
        return layers[i].get(iface, flavour);
    }

    public boolean exists(Interface iface, Flavour flavour) {
        int i = index(iface, flavour);
        if (i != -1) return layers[i].exists(iface, flavour);
        return false;
    }

    private int index(Interface iface, Flavour flavour) {
        for (int i = 0; i < layers.length; i++) {
            if (layers[i].exists(iface, flavour)) return i;
        }
        return -1;
    }
}
