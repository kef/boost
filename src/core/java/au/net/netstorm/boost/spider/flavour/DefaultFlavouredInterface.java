package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFlavouredInterface extends Primordial implements FlavouredInterface {
    private final Interface iface;
    private final Flavour flavour;

    public DefaultFlavouredInterface(Interface iface, Flavour flavour) {
        this.iface = iface;
        this.flavour = flavour;
        validate();
    }

    public Interface getIface() {
        return iface;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    private void validate() {
        if (iface == null) throw new IllegalArgumentException();
        if (flavour == null) throw new IllegalArgumentException();
    }
}
