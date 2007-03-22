package au.net.netstorm.boost.demo.pebble.resolve.singleton;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface ExplicitInstanceRegistry {
    // FIX BREADCRUMB 1824 The 2nd param should be an object you doof.
    void add(Class iface, Class implementation);

    Implementation find(Interface type);
}
