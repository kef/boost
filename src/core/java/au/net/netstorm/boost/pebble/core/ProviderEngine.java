package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface ProviderEngine {

    // SUGGEST:  Strongly type Object[] to Resolved[].
    ResolvedInstance provide(Implementation implementation, Object[] resolved);
}
