package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface Resolver {
    Implementation resolve(Interface type);
}
