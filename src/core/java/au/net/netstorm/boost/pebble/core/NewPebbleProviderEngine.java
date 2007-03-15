package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.Implementation;

public interface NewPebbleProviderEngine {
    Object provider(Implementation implementation, Object[] parameters);
}
