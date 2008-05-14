package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;

public class DefaultImplementationLookup implements ImplementationLookup {
    private final Factories factories;
    private final LinkageFactory linkages;

    public DefaultImplementationLookup(Factories factories, LinkageFactory linkages) {
        this.factories = factories;
        this.linkages = linkages;
    }

    public <T> Class<? extends T> getImplementation(Class<T> iface) {
        Linkage linkage = linkages.nu(iface);
        Factory factory = factories.find(linkage);
        Blueprint blueprint = factory.get(linkage);
        Implementation impl = blueprint.getImplementation();
        return impl.getImpl();
    }
}
