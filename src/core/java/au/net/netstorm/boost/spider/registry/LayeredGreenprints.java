package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Interface;

public final class LayeredGreenprints implements Greenprints {
    private final Greenprints[] layers;

    public LayeredGreenprints(Greenprints[] layers) {
        this.layers = layers;
    }

    public Blueprint get(Interface iface) {
        for (int i = 0; i < layers.length; i++) {
            if (layers[i].exists(iface)) return layers[i].get(iface);
        }
        throw new NonExistentBlueprintException(iface);
    }

    public boolean exists(Interface iface) {
        for (int i = 0; i < layers.length; i++) {
            if (layers[i].exists(iface)) return true;
        }
        return false;
    }
}
