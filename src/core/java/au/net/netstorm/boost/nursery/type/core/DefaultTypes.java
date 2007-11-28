package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.util.impl.ImplMaster;

public class DefaultTypes implements Types {
    ImplMaster impler;
    Nu nu;

    public <T extends Holder> T nu(Class<T> iface, Object value) {
        Class<? extends T> impl = impler.impl(iface);
        return nu.nu(impl, value);
    }
}
