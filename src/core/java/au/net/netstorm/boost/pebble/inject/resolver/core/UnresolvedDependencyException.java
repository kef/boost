package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Interface;

public final class UnresolvedDependencyException extends RuntimeException {
    public UnresolvedDependencyException(Interface iface) {
        super("Such bugs and goblins in my life.  I cannot resolve " + iface);
    }
}