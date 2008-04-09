package au.net.netstorm.boost.nursery.spider.onion.core;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.spider.onion.ring.Ring;

public interface LordOfTheRings {
    boolean ringed(Implementation impl);

    Ring[] rings(Implementation impl);
}
