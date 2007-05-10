package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.primordial.BoostException;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class WrongInterfaceRegistrationException extends RuntimeException implements BoostException {
    public WrongInterfaceRegistrationException(Implementation implementation, Interface iface) {
        super(implementation.getClass() + " does not implement " + iface.getType());
    }
}
