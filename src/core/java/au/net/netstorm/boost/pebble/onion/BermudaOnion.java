package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// SUGGEST: Do some proxy magic in here ;)
public final class BermudaOnion implements Onion {

    public Instance onionise(ResolvedInstance resolved) {
        return (Instance) resolved;
    }
}
