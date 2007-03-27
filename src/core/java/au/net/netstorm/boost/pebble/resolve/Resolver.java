package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public interface Resolver {
    Instance resolve(Interface iface);

    Instance[] resolve(Interface[] ifaces);

    Instance resolve(Implementation impl);
}
