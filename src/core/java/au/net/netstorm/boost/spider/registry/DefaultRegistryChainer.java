package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.chain.Chain;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultRegistryChainer implements RegistryChainer {
    public void chain(Registry registry, Chain chain) {
        Interface type = chain.getType();
        Implementation[] links = chain.getLinks();
        chain(registry, type, links);
    }

    private void chain(Registry registry, Interface type, Implementation[] links) {
        Class iface = type.getType();
        Class[] impls = classes(links);
        chain(registry, iface, impls);
    }

    private void chain(Registry registry, Class iface, Class[] impls) {
        registry.single(iface, impls[0]);
        for (int i = 0; i < impls.length - 1; i++) {
            registry.single(impls[i], iface, impls[i + 1]);
        }
    }

    // FIX 93685 Move into boost.  Coalesce with InterfaceUtil and possibly TypeMaster?
    private Class[] classes(Implementation[] impls) {
        Class[] result = new Class[impls.length];
        for (int i = 0; i < impls.length; i++) {
            result[i] = impls[i].getImpl();
        }
        return result;
    }
}
