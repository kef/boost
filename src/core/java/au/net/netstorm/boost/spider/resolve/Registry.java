package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.flavour.Flavour;

public interface Registry {
    void multiple(Class iface, Class impl);

    void instance(Class iface, Object ref);

    void multiple(Class iface, Class impl, Flavour flavour);

    void instance(Class iface, Object ref, Flavour flavour);
}
