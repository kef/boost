package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface Resolver {
    Object resolve(Interface iface);

    Object[] resolve(Interface[] ifaces);

    Object resolve(Implementation impl);
}
