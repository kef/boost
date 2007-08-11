package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;

public interface Blueprints {
    // FIX 2081 reorg sig (iface, flavour, blueprint).
    void put(Interface iface, Flavour flavour, Blueprint blueprint);

    // FIX 2081 Make this return a BluePrint (Implementation and SINGLE|MULTIPLE)
    // FIX 2081 Create an architect class which stores blueprints.

    Blueprint get(Interface iface, Flavour flavour);

    boolean exists(Interface iface, Flavour flavour);
}
