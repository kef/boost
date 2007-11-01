package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.util.type.Interface;

public class NoImplementationException extends PrimordialException {
    public NoImplementationException(Interface iface) {
        super("No implementation for " + iface);
    }
}
