package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultInjectionType extends Primordial implements InjectionType {
    private final Class<?> raw;

    public DefaultInjectionType(Class<?> raw) {
        if (raw == null) throw new IllegalArgumentException();
        this.raw = raw;
    }

    public InjectionType raw() {
        // FIX 2394 update to strip parameters
        return this;
    }

    public InjectionType[] parameters() {
        throw new UnsupportedOperationException();
    }

    public Class<?> rawClass() {
        return raw;
    }

    public Constructor<?> getConstructor() {
        Constructor<?>[] ctors = raw.getConstructors();
        if (ctors.length != 1) throw new IllegalArgumentException();
        return ctors[0];
    }
}
