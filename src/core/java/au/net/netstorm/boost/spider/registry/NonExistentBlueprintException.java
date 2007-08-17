package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;

public final class NonExistentBlueprintException extends PrimordialException {
    public NonExistentBlueprintException(Interface iface, Flavour flavour) {
        super("Non existent blueprint for " + iface + " with flavour " + flavour);
    }
}
