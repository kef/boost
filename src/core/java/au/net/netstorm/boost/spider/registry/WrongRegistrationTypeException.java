package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.util.type.Implementation;

public final class WrongRegistrationTypeException extends RuntimeException implements BoooostException {
    public WrongRegistrationTypeException(Implementation impl) {
        super(impl + " has a different registration type.");
    }
}
