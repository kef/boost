package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.spider.register.Blueprint;
import au.net.netstorm.boost.spider.register.Factories;
import au.net.netstorm.boost.spider.register.Factory;
import au.net.netstorm.boost.util.type.Implementation;

// FIX (Nov 21, 2007) 2233 Move out of nursery
public class DefaultTypes implements Types {
    private LinkageFactory linkages;
    private Factories factories;
    private Nu nu;

    public DefaultTypes(Factories factories, LinkageFactory linkages, Nu nu) {
        this.factories = factories;
        this.linkages = linkages;
        this.nu = nu;
    }

    public <T> T nu(Class<T> iface, Object value) {
        return doNu(iface, value);
    }

    public <T> T nu(Class<T> iface, Object... values) {
        return doNu(iface, values);
    }

    private <T> T doNu(Class<T> iface, Object... value) {
        Class<? extends T> impl = lookup(iface);
        return nu.nu(impl, value);
    }

    // FIX 2237 Looks like dup with ResolverEngine.
    private <T> Class<? extends T> lookup(Class<T> iface) {
        Linkage linkage = linkages.nu(iface);
        Factory factory = factories.find(linkage);
        Blueprint blueprint = factory.get(linkage);
        Implementation impl = blueprint.getImplementation();
        return impl.getImpl();
    }
}
