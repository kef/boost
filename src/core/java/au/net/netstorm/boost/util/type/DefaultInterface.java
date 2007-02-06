package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;

// This is just an interface.  It is the strong type for interface.
public final class DefaultInterface extends Primordial implements Interface {
    private final Class type;

    public DefaultInterface(Class type) {
        this.type = type;
        validate();
    }

    public Class getType() {
        return type;
    }

    private void validate() {
        if (type == null)
            throw new IllegalArgumentException();
        if (!type.isInterface())
            throw new IllegalArgumentException("Not interface " + type);
    }
}
