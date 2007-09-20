package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultImplementationRef extends Primordial implements ImplementationRef {
    private final Implementation impl;

    public DefaultImplementationRef(Implementation impl) {
        this.impl = impl;
    }

    public Implementation get() {
        return impl;
    }

    public boolean exists() {
        return impl != null;
    }
}
