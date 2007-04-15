package au.net.netstorm.boost.spider.inject.resolver.core;

import au.net.netstorm.boost.util.type.Interface;

public final class AlreadyRegisteredException extends RuntimeException {
    public AlreadyRegisteredException(Interface iface) {
        super(iface + " already registered.");
    }
}
