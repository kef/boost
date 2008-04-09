package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.chain.Chain;

public interface RegistryChainer {
    void chain(Registry registry, Chain chain);

    void chain(Registry registry, Interface type, Implementation... links);

    void chain(Registry registry, Class iface, Class... links);
}
