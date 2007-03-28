package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.WrappedInstance;

public interface Onionizer {
    WrappedInstance onionise(ResolvedInstance ref);
}
