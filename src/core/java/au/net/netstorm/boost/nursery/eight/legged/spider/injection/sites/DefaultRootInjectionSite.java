package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultRootInjectionSite extends Primordial implements RootInjectionSite {
    private final InjectionType type;

    public DefaultRootInjectionSite(InjectionType type) {
        if (type == null) throw new IllegalArgumentException();
        this.type = type;
    }

    public Class<?> host() {
        throw new AssertionError("Implementation Error: Root injections do not have hosts.");
    }

    public InjectionType type() {
        return type;
    }

    public String name() {
       throw new AssertionError("Implementation Error: Root injections do not have names.");
    }

    public boolean isConstrained() {
        return false;
    }
}
