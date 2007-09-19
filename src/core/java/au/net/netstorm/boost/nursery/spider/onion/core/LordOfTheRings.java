package au.net.netstorm.boost.nursery.spider.onion.core;

import au.net.netstorm.boost.nursery.spider.onion.ring.Ring;
import au.net.netstorm.boost.util.type.Implementation;

public interface LordOfTheRings {
    boolean ringed(Implementation impl);

    Ring[] rings(Implementation impl);
}
