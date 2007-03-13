package au.net.netstorm.boost.pebble.newer.core;

import au.net.netstorm.boost.util.type.Interface;

public interface NewerProxySupplier {
    Object create(Interface creatorInterface, Class instanceImplementation);
}
