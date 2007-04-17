package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Finder {
    Implementation getImplementation(Interface iface);

    boolean hasInstance(Interface iface);

    ResolvedInstance getInstance(Interface iface);

    boolean hasImplementation(Interface iface);

    Interface[] getKeys();
}
