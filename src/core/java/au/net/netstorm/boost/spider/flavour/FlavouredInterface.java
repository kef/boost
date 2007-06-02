package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.Interface;

public interface FlavouredInterface extends Data {
    Interface getIface();

    Flavour getFlavour();
}
