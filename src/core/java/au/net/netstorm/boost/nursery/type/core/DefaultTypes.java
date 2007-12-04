package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Data;

// FIX (Nov 21, 2007) 2233 Move out of nursery
public class DefaultTypes implements Types {
    ImplMaster impler;
    Nu nu;

    public <T extends Holder> T nu(Class<T> iface, Object value) {
        Class<? extends T> impl = impler.impl(iface);
        return nu.nu(impl, value);
    }

    public <T extends Data> T nu(Class<T> iface, Object... values) {
        Class<? extends T> impl = impler.impl(iface);
        return nu.nu(impl, values);
    }
}
