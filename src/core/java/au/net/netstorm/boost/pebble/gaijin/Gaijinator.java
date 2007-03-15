package au.net.netstorm.boost.pebble.gaijin;

import au.net.netstorm.boost.pebble.instantiate.Instantiator;

// FIX 1715 Should gaijin live in the "pebble" package?
public interface Gaijinator extends Instantiator {
    boolean isGaijin(Class type);
}
