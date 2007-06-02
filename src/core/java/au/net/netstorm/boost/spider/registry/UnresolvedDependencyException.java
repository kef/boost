package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Interface;

public final class UnresolvedDependencyException extends RuntimeException {
    public UnresolvedDependencyException(Interface iface) {
        super("Such bugs and goblins in my life. \nI cannot resolve " + iface);
    }
}
