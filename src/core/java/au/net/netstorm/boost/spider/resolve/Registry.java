package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.Interface;

public interface Registry {
    void prototype(Class iface, Class impl);

    void instance(Class iface, Object ref);

    Interface[] getKeys();
}
