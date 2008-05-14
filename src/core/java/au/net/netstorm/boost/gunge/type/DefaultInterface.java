package au.net.netstorm.boost.gunge.type;

import au.net.netstorm.boost.bullet.primordial.Primordial;

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

    public int hashCode() {
        return type.hashCode();
    }

    private void validate() {
        if (type == null) throw new IllegalArgumentException();
        if (!validType()) throw new IllegalArgumentException("Not interface or enum: " + type);
    }

    // FIX Treating an enum as an interface is powerful even though it isn't
    // FIX We can now register/resolve/inject enums, but is it "correct"?
    private boolean validType() {
        if (type.isInterface()) return true;
        if (type.isEnum()) return true;
        return false;
    }
}
