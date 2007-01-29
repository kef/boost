package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Do some proxy magic in here ;)
public final class BermudaOnion implements Onion {
    public Object onionize(Object ref, Interface type) {
        return ref;   
    }
}
