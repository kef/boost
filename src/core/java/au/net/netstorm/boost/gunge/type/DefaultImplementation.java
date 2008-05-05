package au.net.netstorm.boost.gunge.type;

import au.net.netstorm.boost.bullet.primordial.Primordial;

// FIX 2328 Back into gunge.

// FIX 2299 Up coverage and out of nursery.
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
        // FIX 2328 Barf nicely if null.  Use to be.
//        if (impl == null) throw new IllegalArgumentException();
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
