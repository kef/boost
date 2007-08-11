package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.Interface;

public interface BlueprintMaster extends Blueprints {
    // FIX 2081 Either combine all iterfaces or not at all.

    void blueprint(Interface iface, Blueprint blueprint, Flavour flavour);
}
