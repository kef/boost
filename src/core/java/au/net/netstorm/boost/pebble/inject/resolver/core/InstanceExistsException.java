package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Interface;

public final class InstanceExistsException extends RuntimeException {
    public InstanceExistsException(Interface iface) {
        super("Instance already exists for " + iface);
    }
}
