package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultBlueprint extends Primordial implements Blueprint {
    private final Stamp stamp;
    private final Implementation implementation;

    public DefaultBlueprint(Stamp stamp, Implementation implementation) {
        this.stamp = stamp;
        this.implementation = implementation;
        validate();
    }

    public Stamp getStamp() {
        return stamp;
    }

    public Implementation getImplementation() {
        return implementation;
    }

    private void validate() {
        if (stamp == null) throw new IllegalArgumentException();
        if (implementation == null) throw new IllegalArgumentException();
    }
}
