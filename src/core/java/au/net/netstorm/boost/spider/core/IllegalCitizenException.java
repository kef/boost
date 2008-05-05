package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.bullet.primordial.PrimordialException;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

public final class IllegalCitizenException extends PrimordialException {
    public IllegalCitizenException(Interface marker, Implementation impl) {
        super("I know you want to be my darling,... \nbut you're not a " + marker + " -> " + impl);
    }
}
