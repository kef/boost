package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.util.type.Implementation;

public interface PebbleProviderEngine {
    // FIX 1779 Strongly type Object[] to Resolved[].
    Object provide(Implementation implementation, Object[] resolved);
}
