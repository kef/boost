package au.net.netstorm.boost.nursery.spider.provider;

import au.net.netstorm.boost.provider.Nu;
import au.net.netstorm.boost.spider.core.NoInterface;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX NOW Move out of "nursery".
public final class DefaultNu implements Nu {
    private final ProviderEngine engine;

    public DefaultNu(ProviderEngine engine) {
        this.engine = engine;
    }

    public <T> T nu(Class<T> impl, Object param) {
        return nu(impl, new Object[]{param});
    }

    public <T> T nu(Class<T> impl, Object... params) {
        Interface iface = new DefaultInterface(NoInterface.class);
        Implementation implementation = new DefaultImplementation(impl);
        ResolvedInstance resolved = engine.provide(iface, implementation, params);
        return (T) resolved.getRef();
    }
}
