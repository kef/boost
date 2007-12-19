package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolver implements Resolver {
    private static final Implementation NO_IMPL = new DefaultImplementation(NoContext.class);
    private final ResolverEngine engine;

    public DefaultResolver(ResolverEngine engine) {
        this.engine = engine;
    }

    public <T> T resolve(Class<T> type) {
        Interface iface = new DefaultInterface(type);
        ResolvedInstance resolved = engine.resolve(iface, NO_IMPL);
        Object o = resolved.getRef();
        return type.cast(o);
    }
}
