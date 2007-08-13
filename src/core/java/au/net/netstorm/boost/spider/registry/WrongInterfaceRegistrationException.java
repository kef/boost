package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class WrongInterfaceRegistrationException extends RuntimeException implements BoooostException {
    public WrongInterfaceRegistrationException(Implementation impl, Interface iface) {
        super(impl + " does not implement " + iface);
    }
}
