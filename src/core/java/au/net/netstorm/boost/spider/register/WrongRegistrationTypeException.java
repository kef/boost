package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.bullet.primordial.BoooostException;
import au.net.netstorm.boost.gunge.type.Implementation;

public final class WrongRegistrationTypeException extends RuntimeException implements BoooostException {
    public WrongRegistrationTypeException(Implementation impl) {
        super(impl + " has a different registration type.");
    }
}
