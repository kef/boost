package au.net.netstorm.boost.nursery.spider.onion.core;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.spider.onion.ring.Ring;

// FIX 1887 Complete.
public final class DefaultLordOfTheRings implements LordOfTheRings {
    public boolean ringed(Implementation impl) {
        return rings(impl).length == 0;
    }

    public Ring[] rings(Implementation impl) {
        return new Ring[]{};
    }
}
