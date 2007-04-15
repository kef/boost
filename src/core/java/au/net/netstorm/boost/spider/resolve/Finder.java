package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Finder {
    Implementation getImplementation(Interface iface);

    boolean hasInstance(Interface iface);

    // FIX BREADCRUMB 32755 Make this a resolved instance.
    ResolvedInstance getInstance(Interface iface);

    boolean hasImplementation(Interface iface);
}
