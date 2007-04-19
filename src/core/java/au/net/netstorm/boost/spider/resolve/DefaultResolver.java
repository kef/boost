package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultResolver implements Resolver {
    private final ResolverEngine engine;

    // FIX BREADCRUMB 1914 Complete.
    public DefaultResolver(ResolverEngine engine) {
        this.engine = engine;
    }

    public Object resolve(Class type) {
        Interface iface = new DefaultInterface(type);
        engine.resolve(iface);
        return null;
    }
}
