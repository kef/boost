package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultNu implements Nu {
    private final ProviderEngine engine;

    public DefaultNu(ProviderEngine engine) {
        this.engine = engine;
    }

    public <T> T nu(Class<T> impl, Object... params) {
        Implementation implementation = new DefaultImplementation(impl);
        ResolvedInstance resolved = engine.provide(implementation, params);
        Object ref = resolved.getRef();
        return impl.cast(ref);
    }
}
