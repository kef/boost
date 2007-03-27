package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.WrappedInstance;

public interface PebbleProviderEngine {

    // SUGGEST:  Strongly type Object[] to Resolved[].
    WrappedInstance provide(Implementation implementation, Object[] resolved);
}
