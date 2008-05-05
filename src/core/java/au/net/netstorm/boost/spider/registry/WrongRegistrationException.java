package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.bullet.primmm.BoooostException;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.spider.linkage.Linkage;

public final class WrongRegistrationException extends RuntimeException implements BoooostException {
    public WrongRegistrationException(Implementation impl, Linkage linkage) {
        super("Cannot link " + impl + " to " + linkage);
    }
}
