package au.net.netstorm.boost.nursery.pebble.type;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplementation extends Primordial implements Implementation {
    Interface type;
    Class impl;

    // FIX 1665 Two constructors?
    public DefaultImplementation(Interface type, Class impl) {
        // FIX 1665 This should check the impl actually implements the type. 
        this.type = type;
        this.impl = impl;
        check();
    }

    public Interface getType() {
        return type;
    }

    public Class getImpl() {
        return impl;
    }

    private void check() {
        if (type == null) throw new IllegalArgumentException();
        if (impl == null) throw new IllegalArgumentException();
    }
}
