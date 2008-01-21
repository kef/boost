package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.util.impl.ImplMaster;

// FIX (Nov 21, 2007) 2233 Move out of nursery
public class DefaultTypes implements Types {
    ImplMaster impler;
    Nu nu;

    public <T> T nu(Class<T> iface, Object value) {
        return doNu(iface, value);
    }

    public <T> T nu(Class<T> iface, Object... values) {
        return doNu(iface, values);
    }

    private <T> T doNu(Class<T> iface, Object... value) {
        Class<? extends T> impl = impler.impl(iface);
        return nu.nu(impl, value);
    }
}
