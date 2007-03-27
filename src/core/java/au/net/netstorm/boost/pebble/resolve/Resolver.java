package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.WrappedInstance;

public interface Resolver {
    WrappedInstance resolve(Interface iface);

    WrappedInstance[] resolve(Interface[] ifaces);

    WrappedInstance resolve(Implementation impl);
}
