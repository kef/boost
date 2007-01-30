package au.net.netstorm.boost.nursery.pebble.onion;

import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Do some proxy magic in here ;)
// FIX 1665 Pass in a Resolved object.
public final class BermudaOnion implements Onion {
    public Object onionize(Object ref, Interface[] types) {
        return ref;   
    }
}
