package au.net.netstorm.boost.demo.pebble.resolve.singleton;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultExplicitInstanceRegistry implements ExplicitInstanceRegistry {
    // FIX BREADCRUMB 1824 Can we strongly type 'ref'? e.g. Singleton type?
    public void add(Class iface, Object ref) {
        throw new UnsupportedOperationException();
    }

    public Implementation find(Interface type) {
        throw new UnsupportedOperationException();
    }
}
