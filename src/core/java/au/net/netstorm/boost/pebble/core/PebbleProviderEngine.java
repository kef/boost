package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;

public interface PebbleProviderEngine {

    // SUGGEST:  Strongly type Object[] to Resolved[].
    Instance provide(Implementation implementation, Object[] resolved);
}
