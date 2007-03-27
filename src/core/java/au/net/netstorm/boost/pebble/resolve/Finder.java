package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.WrappedInstance;

public interface Finder {
    Implementation getImplementation(Interface iface);

    boolean hasInstance(Interface iface);

    WrappedInstance getInstance(Interface iface);

    boolean hasImplementation(Interface iface);
}
