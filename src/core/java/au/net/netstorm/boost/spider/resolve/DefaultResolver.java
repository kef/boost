package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolver implements Resolver {
    private final ResolverEngine engine;

    public DefaultResolver(ResolverEngine engine) {
        this.engine = engine;
    }

    public Object resolve(Class type) {
        Interface iface = new DefaultInterface(type);
        Implementation impl = new DefaultImplementation(NoContext.class);
        ResolvedInstance resolved = engine.resolve(iface, impl);
        return resolved.getRef();
    }
}
