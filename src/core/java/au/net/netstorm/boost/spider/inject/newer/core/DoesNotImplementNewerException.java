package au.net.netstorm.boost.spider.inject.newer.core;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.util.type.Interface;

public final class DoesNotImplementNewerException extends PrimordialException {

    public DoesNotImplementNewerException(Interface type, Interface marker) {
        super(type + " should implement " + marker);
    }
}
