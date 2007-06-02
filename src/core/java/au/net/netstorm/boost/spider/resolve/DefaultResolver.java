package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolver implements Resolver {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private final ResolverEngine engine;

    public DefaultResolver(ResolverEngine engine) {
        this.engine = engine;
    }

    // FIX 1977 Consider whether we need to resolve flavours.  Probably.

    public Object resolve(Class type) {
        Interface iface = new DefaultInterface(type);
        // FIX BREADCRUMB 1977 Get real flavour.
        ResolvedInstance resolved = engine.resolve(iface, UNFLAVOURED);
        return resolved.getRef();
    }
}
