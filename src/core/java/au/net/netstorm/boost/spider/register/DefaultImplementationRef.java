package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Implementation;

// FIX 2145 Revisit this.  Can we just use Implementation.
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
