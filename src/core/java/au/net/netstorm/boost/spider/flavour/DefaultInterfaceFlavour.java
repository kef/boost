package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultInterfaceFlavour extends Primordial implements InterfaceFlavour {
    private final Interface iface;
    private final Flavour flavour;

    public DefaultInterfaceFlavour(Interface iface, Flavour flavour) {
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
