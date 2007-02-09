package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.util.type.Interface;

public interface CreatorProxySupplier {
    Object create(Interface creatorInterface, Class instanceImplementation);
}
