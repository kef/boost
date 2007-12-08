package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;

// This is just an interface.  It is the strong type for interface.
public final class DefaultInterface<T> extends Primordial implements Interface<T> {
    private final Class<T> type;

    public DefaultInterface(Class<T> type) {
        this.type = type;
        validate();
    }

    public Class<T> getType() {
        return type;
    }

    private void validate() {
        if (type == null)
            throw new IllegalArgumentException();
        if (!type.isInterface())
            throw new IllegalArgumentException("Not interface " + type);
    }

    public int hashCode() {
        return type.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Interface)) return false;
        Interface iface = (Interface) obj;
        Class cls = iface.getType();
        return type.equals(cls);
    }
}
