package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.util.type.Implementation;

public interface Resolver {
    Object resolve(Implementation iface);
}
