package au.net.netstorm.boost.gunge.impl;

import au.net.netstorm.boost.bullet.primordial.PrimordialException;
import au.net.netstorm.boost.gunge.type.Interface;

public class NoImplementationException extends PrimordialException {
    public NoImplementationException(Interface iface) {
        super("No implementation for " + iface);
    }
}
