package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public interface RegistryEngine {
    void implementation(Interface iface, Implementation implementation);

    void instance(Interface iface, Instance instance);
}
