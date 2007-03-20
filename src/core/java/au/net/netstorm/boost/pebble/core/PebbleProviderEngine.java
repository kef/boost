package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.util.type.Implementation;

public interface PebbleProviderEngine {
    Object provide(Implementation implementation, Object[] parameters);
}
