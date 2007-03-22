package au.net.netstorm.boost.demo.pebble.resolve.singleton;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultExplicitInstanceRegistry implements ExplicitInstanceRegistry {
    public void add(Class iface, Class implementation) {
        throw new UnsupportedOperationException();
    }

    public Implementation find(Interface type) {
        throw new UnsupportedOperationException();
    }
}
