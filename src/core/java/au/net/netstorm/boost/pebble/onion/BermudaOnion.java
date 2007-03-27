package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.WrappedInstance;

// FIX BREADCRUMB 32755 This is an onioniser.
// FIX 32755 We only have two Instances: ResolvedInstance and Unresolved instance.
// FIX 32755 Use the Onion interface to mark the front door proxy.
// FIX 32755 Create a utility to determine whether an object reference is an onion or not.

// SUGGEST: Do some proxy magic in here ;)
public final class BermudaOnion implements Onion {

    public WrappedInstance onionise(ResolvedInstance resolved) {
        return (WrappedInstance) resolved;
    }
}
