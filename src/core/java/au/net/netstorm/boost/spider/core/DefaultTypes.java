package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.resolve.ImplementationLookup;

// FIX (Nov 21, 2007) 2233 Move out of nursery
public class DefaultTypes implements Types {
    private NuImpl nuImpl;
    private ImplementationLookup lookup;

    public DefaultTypes(ImplementationLookup lookup, NuImpl nuImpl) {
        this.lookup = lookup;
        this.nuImpl = nuImpl;
    }

    public <T> T nu(Class<T> iface, Object... values) {
        Class<? extends T> impl = lookup.getImplementation(iface);
        return nuImpl.nu(impl, values);
    }
}
