package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.util.type.Interface;

public final class WrongRegistrationTypeException extends RuntimeException implements BoooostException {
    public WrongRegistrationTypeException(Interface type) {
        super(type + " has a different registration type.");
    }
}
