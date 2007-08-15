package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultProvider implements Provider {
    private static final Object[] NO_PARAMETERS = {};
    private final ProviderEngine engine;

    public DefaultProvider(ProviderEngine engine) {
        this.engine = engine;
    }

    public Object provide(Class type) {
        return provide(type, NO_PARAMETERS);
    }

    private Object provide(Class type, Object[] parameters) {
        Implementation implementation = new DefaultImplementation(type);
        ResolvedInstance instance = engine.provide(implementation, parameters);
        return instance.getRef();
    }
}
