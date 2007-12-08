package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultBaseReference<T> extends Primordial implements BaseReference {
    private final T ref;

    public DefaultBaseReference(T ref) {
        this.ref = ref;
        validate();
    }

    public T getRef() {
        return ref;
    }

    private void validate() {
        if (ref == null) throw new IllegalArgumentException();
    }
}
