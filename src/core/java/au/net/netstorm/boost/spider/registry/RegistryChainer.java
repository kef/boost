package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.chain.Chain;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface RegistryChainer {
    void chain(Registry registry, Chain chain);

    void chain(Registry registry, Interface type, Implementation... links);

    void chain(Registry registry, Class iface, Class... links);
}
