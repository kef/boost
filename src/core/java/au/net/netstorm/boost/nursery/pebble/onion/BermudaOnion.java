package au.net.netstorm.boost.nursery.pebble.onion;

import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Do some proxy magic in here ;)
public final class BermudaOnion implements Onion {

    public Object onionize(Object ref) {
        return ref;
    }
}
