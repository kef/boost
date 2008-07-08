package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultInjectionType<T> extends Primordial implements InjectionType {
    private final Class<T> raw;

    public DefaultInjectionType(Class<T> raw) {
        if (raw == null) throw new IllegalArgumentException();
        this.raw = raw;
    }

    public InjectionType<T> raw() {
        // FIX 2394 update to strip parameters
        return this;
    }

    public InjectionType<?>[] parameters() {
        // FIX 2394 MAG Is this really UOE.  If not consider ISE.
        // FIX 2394 see fix on interface. needs to be implemented.
        throw new UnsupportedOperationException();
    }

    public Class<T> rawClass() {
        return raw;
    }
}
