package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.Constructable;
import au.net.netstorm.boost.spider.core.Types;

final class DefaultX implements X, Constructable {
    Types types;

    public void constructor() {
        types.nu(Z.class);
    }
}
