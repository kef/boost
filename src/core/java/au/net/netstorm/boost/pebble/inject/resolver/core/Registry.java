package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public interface Registry {
    boolean hasImplementation(Interface iface);

    boolean hasInstance(Interface iface);

    Implementation getImplementation(Interface iface);

    Instance getInstance(Interface iface);

    void prototype(Class iface, Class implClass);

    void instance(Class iface, Object ref);
}
