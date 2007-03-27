package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.Instance;

// SUGGEST: Do some proxy magic in here ;)
public final class BermudaOnion implements Onion {

    public Instance onionise(Object ref) {
        return new DefaultInstance(ref);
    }
}
