package au.net.netstorm.boost.provider;

import au.net.netstorm.boost.primordial.PrimordialException;

public final class NotProvidedException extends PrimordialException {

    public NotProvidedException(Class type) {
        super("Could not provide type: " + type);
    }
}
