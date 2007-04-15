package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.primordial.BoostException;
import au.net.netstorm.boost.util.type.Interface;

public final class WrongRegistrationTypeException extends RuntimeException implements BoostException {
    public WrongRegistrationTypeException(Interface type) {
        super(type + " has a different registration type.");
    }
}
