package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;

public interface Blueprints {
    // FIX 2081 Make this return a BluePrint (Implementation and SINGLE|MULTIPLE)
    // FIX 2081 Create an architect class which stores blueprints.
    // FIX 2081 Split instance vs implementation.

    // FIX BREADCRUMB 2081 BBBBBBBBBBBBBBBBBBBBBBBBB Make this return a blue print.

    Blueprint getBlueprint(Interface iface, Flavour flavour);

    boolean hasBlueprint(Interface iface, Flavour flavour);
}
