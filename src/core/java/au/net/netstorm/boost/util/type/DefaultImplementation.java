package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultImplementation<T> extends Primordial implements Implementation<T> {
    private final Class<T> impl;

    public DefaultImplementation(Class<T> impl) {
        this.impl = impl;
        validate();
    }

    public Class<T> getImpl() {
        return impl;
    }

    private void validate() {
        if (impl == null) throw new IllegalArgumentException();
        if (impl.isInterface()) {
            String failMessage = impl + " should be an implementation and not an interface.";
            throw new IllegalArgumentException(failMessage);
        }
    }
}
