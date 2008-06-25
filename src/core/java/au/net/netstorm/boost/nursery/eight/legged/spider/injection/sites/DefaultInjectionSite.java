package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.spider.linkage.Linkage;

public final class DefaultInjectionSite extends Primordial implements InjectionSite {
    private final Class<?> host;
    private final InjectionType type;
    private final String name;

    public DefaultInjectionSite(Class<?> host, InjectionType type, String name) {
        if (host == null || type == null || name == null) throw new IllegalArgumentException();
        this.host = host;
        this.type = type;
        this.name = name;
    }

    // FIX 2328 incremental step, eventually just use injection sites where applicable
    public Linkage toLinkage() {
        throw new UnsupportedOperationException();
    }

    public Class<?> host() { return this.host; }
    public InjectionType type() { return this.type; }
    public String name() { return this.name; }
}
