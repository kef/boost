package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.Constructable;
import au.net.netstorm.boost.spider.instantiate.Nu;

final class DefaultX implements X, Constructable {
    Nu nu;

    public void constructor() {
        nu.nu(DefaultZ.class);
    }
}
