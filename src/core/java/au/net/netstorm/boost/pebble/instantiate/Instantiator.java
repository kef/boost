package au.net.netstorm.boost.pebble.instantiate;

import au.net.netstorm.boost.util.type.Implementation;

public interface Instantiator {
    Object instantiate(Implementation impl, Object[] parameters);
}
