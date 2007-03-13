package au.net.netstorm.boost.pebble.create.core;

import au.net.netstorm.boost.util.type.Interface;

public interface NewerProxySupplier {
    Object create(Interface creatorInterface, Class instanceImplementation);
}
