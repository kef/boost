package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;

public interface PebbleProviderEngine {

    // FIX 32755 Strong type Object[] to Parameter[].

    // SUGGEST:  Strongly type Object[] to Resolved[].

    Instance provide(Implementation implementation, Object[] resolved);
}
