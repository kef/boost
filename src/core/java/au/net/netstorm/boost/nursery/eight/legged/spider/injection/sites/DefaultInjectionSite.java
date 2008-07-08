package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX 2395 Do we want a ConstructorInjectionSite for symmetry with Field/Root ISs?
public class DefaultInjectionSite extends Primordial implements InjectionSite {
    private final Class<?> host;
    private final InjectionType type;
    private final String name;

    public DefaultInjectionSite(Class<?> host, InjectionType type, String name) {
        // FIX 2394 MAG Null checking.
        if (host == null || type == null || name == null) throw new IllegalArgumentException();
        this.host = host;
        this.type = type;
        this.name = name;
    }

    public Class<?> host() { return this.host; }
    public InjectionType type() { return this.type; }
    public String name() { return this.name; }
}
