package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultImplementation extends Primordial implements Implementation {
    private final Class impl;

    public DefaultImplementation(Class impl) {
        this.impl = impl;
        validate();
    }

    public Class getImpl() {
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
