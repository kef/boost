package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.util.type.Implementation;

public final class WrongRegistrationException extends RuntimeException implements BoooostException {
    public WrongRegistrationException(Implementation impl, Linkage linkage) {
        super("Cannot link " + impl + " to " + linkage);
    }
}
