package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Interface;

public interface Factories {
    Factory find(Interface iface);

    void add(Factory factory);
}
