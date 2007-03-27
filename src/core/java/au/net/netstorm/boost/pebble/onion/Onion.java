package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.WrappedInstance;

public interface Onion {
    WrappedInstance onionise(Instance ref);
}
