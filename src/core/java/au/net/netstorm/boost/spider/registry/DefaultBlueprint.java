package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Implementation;

// FIX 2237 Reinstate null intolerance.
public final class DefaultBlueprint extends Primordial implements Blueprint {
    private final Stamp stamp;
    private final Implementation implementation;
    private final Object[] parameters;

    public DefaultBlueprint(Stamp stamp, Implementation implementation, Object[] parameters) {
        this.stamp = stamp;
        this.implementation = implementation;
        this.parameters = parameters.clone();
    }

    public Stamp getStamp() {
        return stamp;
    }

    public Implementation getImplementation() {
        return implementation;
    }

    public Object[] getParameters() {
        return parameters.clone();
    }
}
