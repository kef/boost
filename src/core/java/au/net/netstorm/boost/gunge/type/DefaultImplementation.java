package au.net.netstorm.boost.gunge.type;

import au.net.netstorm.boost.bullet.primordial.Primordial;

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
        if (impl == null) throw new IllegalArgumentException("implementation can not be null");
        // FIX 2328 This logic is symmetric with DefaultInterface.  Extract logic.
        if (impl.isInterface()) {
            String failMessage = impl + " should be an implementation and not an interface.";
            throw new IllegalArgumentException(failMessage);
        }
    }

    public int hashCode() {
        return impl.hashCode();
    }
}
