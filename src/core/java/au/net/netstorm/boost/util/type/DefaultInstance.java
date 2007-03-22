package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultInstance extends Primordial implements Instance {
    private final Object ref;

    public DefaultInstance(Object ref) {
        this.ref = ref;
        validate();
    }

    public Object getRef() {
        return ref;
    }

    private void validate() {
        if (ref == null) throw new IllegalArgumentException();
    }
}
