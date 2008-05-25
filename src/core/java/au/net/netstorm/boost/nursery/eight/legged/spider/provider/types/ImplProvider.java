package au.net.netstorm.boost.nursery.eight.legged.spider.provider.types;

import au.net.netstorm.boost.gunge.type.Implementation;

public final class ImplProvider implements Provider {
    // FIX 2394 Interface?
    // FIX 2394 can't be, not everything has an interface... maybe that could be changed,
    // FIX 2394 idea at the moment is that providers are not concerned with that resolution
    // FIX 2394 as they are more re-usable as really dumb instantiators
    // FIX 2394 all the smarts (and where new functionality gets plugged in) is in Factories
    public ImplProvider(Implementation impl) {}
}
