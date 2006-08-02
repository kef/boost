package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;

// This is just an interface.  It is the strong type for interface.

public final class Interface extends Primordial implements Data {
    private final Class type;

    public Interface(Class type) {
        if (type == null) throw new IllegalArgumentException();
        if (!type.isInterface()) throw new IllegalArgumentException();
        this.type = type;
    }

    public Class getType() {
        return type;
    }
}
