package au.net.netstorm.boost.pebble.instantiate;

import au.net.netstorm.boost.pebble.type.Implementation;

public interface Instantiator {
    Object instantiate(Implementation impl, Object[] parameters);
}
