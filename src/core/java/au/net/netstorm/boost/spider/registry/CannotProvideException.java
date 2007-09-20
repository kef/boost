package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.util.type.Interface;

public final class CannotProvideException extends PrimordialException {
    public CannotProvideException(Interface iface) {
        super("Cannot provide an implementation for interface " + iface);
    }
}
