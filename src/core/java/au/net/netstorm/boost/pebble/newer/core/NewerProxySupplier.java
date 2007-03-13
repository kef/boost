package au.net.netstorm.boost.pebble.newer.core;

import au.net.netstorm.boost.util.type.Interface;

public interface NewerProxySupplier {
    Object nu(Interface newerInterface, Class instanceImplementation);
}
