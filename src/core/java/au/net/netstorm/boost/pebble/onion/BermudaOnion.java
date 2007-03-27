package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.WrappedInstance;

// SUGGEST: Do some proxy magic in here ;)
public final class BermudaOnion implements Onion {

    public WrappedInstance onionise(Instance resolved) {
        return (WrappedInstance) resolved;
    }
}
