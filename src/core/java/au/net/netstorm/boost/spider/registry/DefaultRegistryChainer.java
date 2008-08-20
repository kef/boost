package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.chain.Chain;

public final class DefaultRegistryChainer implements RegistryChainer {
    public void chain(Registry registry, Chain chain) {
        Interface type = chain.getType();
        Implementation[] links = chain.getLinks();
        chain(registry, type, links);
    }

    public void chain(Registry registry, Interface type, Implementation... links) {
        Class iface = type.getType();
        Class[] impls = classes(links);
        chain(registry, iface, impls);
    }

    public void chain(Registry registry, Class iface, Class... links) {
        registry.single(iface, links[0]);
        for (int i = 0; i < links.length - 1; i++) {
            registry.single(links[i], iface, links[i + 1]);
        }
    }

    // FIX 2248 Coalesce with InterfaceMaster and possibly TypeMaster?
    private Class[] classes(Implementation[] impls) {
        Class[] result = new Class[impls.length];
        for (int i = 0; i < impls.length; i++) {
            result[i] = impls[i].getImpl();
        }
        return result;
    }
}
