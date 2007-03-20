package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultResolver implements Resolver {
    private final PebbleProviderEngine provider;

    public DefaultResolver(PebbleProviderEngine provider) {
        this.provider = provider;
    }

    public Object resolve(Implementation iface) {
        return provider.provide(iface, new Object[]{});
    }
}
