package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Resolver {
    ResolvedInstance resolve(Interface iface);

    ResolvedInstance[] resolve(Interface[] ifaces);

    ResolvedInstance resolve(Implementation impl);
}
