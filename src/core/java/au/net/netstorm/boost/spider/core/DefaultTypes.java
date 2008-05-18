package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.resolve.ImplementationLookup;

// FIX (Nov 21, 2007) 2233 Move out of nursery
public class DefaultTypes implements Types {
    private Nu nu;
    private ImplementationLookup lookup;

    public DefaultTypes(ImplementationLookup lookup, Nu nu) {
        this.lookup = lookup;
        this.nu = nu;
    }

    public <T> T nu(Class<T> iface, Object... values) {
        Class<? extends T> impl = lookup.getImplementation(iface);
        return nu.nu(impl, values);
    }
}
