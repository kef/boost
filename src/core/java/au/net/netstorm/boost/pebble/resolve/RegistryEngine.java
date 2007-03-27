package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface RegistryEngine {
    void implementation(Interface iface, Implementation implementation);

    void instance(Interface iface, ResolvedInstance instance);
}
