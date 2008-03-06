package au.net.netstorm.boost.nursery.util.type;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Implementation;

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
        if (impl == null) throw new IllegalArgumentException();
        if (impl.isInterface()) {
            String failMessage = impl + " should be an implementation and not an interface.";
            throw new IllegalArgumentException(failMessage);
        }
    }

    public int hashCode() {
        return impl.hashCode();
    }

    // FIX () BREADCRUMB   2237 REMOVE THIS.  IT WAS COPY AND PASTED IN!!!!!!!!!!!
    public boolean equals(Object obj) {
        if (!(obj instanceof Implementation)) return false;
        Implementation implementation = (Implementation) obj;
        Class cls = implementation.getImpl();
        return impl.equals(cls);
    }
}
