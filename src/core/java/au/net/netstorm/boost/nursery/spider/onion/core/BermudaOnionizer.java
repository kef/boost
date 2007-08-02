package au.net.netstorm.boost.nursery.spider.onion.core;

import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 1887 Use the Onion interface to mark the front door proxy.
// FIX 1887 Create a utility to determine whether an object reference is an onion or not.

// SUGGEST: Do some proxy magic in here ;)

// FIX 1887 Complete.
public final class BermudaOnionizer implements Onionizer {

    public ResolvedInstance onionise(ResolvedInstance resolved) {
        Object ref = resolved.getRef();
        Object proxy = proxy(ref);
        return new DefaultBaseReference(proxy);
    }

    // FIX BREADCRUMB 1887 AAAAAAAAAAAAAAAAAAAAAAAAAAA Here.  Put in proxy for every thing.
    private Object proxy(Object ref) {
        return ref;
    }
}
