package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 32755 Use the Onion interface to mark the front door proxy.
// FIX 32755 Create a utility to determine whether an object reference is an onion or not.

// SUGGEST: Do some proxy magic in here ;)
public final class BermudaOnionizer implements Onionizer {

    public ResolvedInstance onionise(ResolvedInstance resolved) {
        return resolved;
    }
}
