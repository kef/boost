package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 1887 Use the Onion interface to mark the front door proxy.
// FIX 1887 Create a utility to determine whether an object reference is an onion or not.

// SUGGEST: Do some proxy magic in here ;)
public final class BermudaOnionizer implements Onionizer {

    public ResolvedInstance onionise(ResolvedInstance resolved) {
        return resolved;
    }
}
