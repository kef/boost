package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.util.type.Interface;

// FIX 2145 This class looks exactly like the newer version of this exception.
public final class DoesNotImplementFactoryException extends PrimordialException {
    public DoesNotImplementFactoryException(Class cls, Interface marker) {
        super(cls + " should implement " + marker);
    }
}
