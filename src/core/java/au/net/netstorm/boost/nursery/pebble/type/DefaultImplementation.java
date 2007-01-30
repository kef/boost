package au.net.netstorm.boost.nursery.pebble.type;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplementation extends Primordial implements Implementation {
    Interface[] types;
    Class impl;

    // FIX 1665 Two constructors?
    public DefaultImplementation(Interface[] types, Class impl) {
        // FIX 1665 This should check the impl actually implements the type.
        if (types == null) throw new IllegalArgumentException();
        if (impl == null) throw new IllegalArgumentException();
        this.types = (Interface[]) types.clone();
        this.impl = impl;
    }

    public Interface[] getTypes() {
        return (Interface[]) types.clone();
    }

    public Class getImpl() {
        return impl;
    }
}
