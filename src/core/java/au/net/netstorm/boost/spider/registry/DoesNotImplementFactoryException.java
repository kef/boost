package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.util.type.Interface;

public final class DoesNotImplementFactoryException extends PrimordialException {
    public DoesNotImplementFactoryException(Class cls, Interface marker) {
        super(cls + " should implement " + marker);
    }
}
