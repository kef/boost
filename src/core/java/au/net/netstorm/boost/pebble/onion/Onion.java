package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Onion {
    Instance onionise(ResolvedInstance ref);
}
