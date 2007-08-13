package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultBlueprint extends Primordial implements Blueprint {
    private final Stamp stamp;
    private final Implementation implementation;
    private final Flavour flavour;

    public DefaultBlueprint(Stamp stamp, Implementation implementation, Flavour flavour) {
        this.stamp = stamp;
        this.implementation = implementation;
        this.flavour = flavour;
        validate();
    }

    public Stamp getStamp() {
        return stamp;
    }

    public Implementation getImplementation() {
        return implementation;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    private void validate() {
        if (stamp == null) throw new IllegalArgumentException();
        if (implementation == null) throw new IllegalArgumentException();
        if (flavour == null) throw new IllegalArgumentException();
    }
}
