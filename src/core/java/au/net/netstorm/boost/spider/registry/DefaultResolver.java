package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolver implements Resolver {
    private final ResolverEngine engine;

    public DefaultResolver(ResolverEngine engine) {
        this.engine = engine;
    }

    public Object resolve(Class type) {
        Interface iface = new DefaultInterface(type);
        // FIX BREADCRUMB 1977 Get real flavour.
        Flavour flavour = null;
        ResolvedInstance resolved = engine.resolve(iface, flavour);
        return resolved.getRef();
    }
}
