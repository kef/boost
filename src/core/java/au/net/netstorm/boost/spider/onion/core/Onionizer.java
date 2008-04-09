package au.net.netstorm.boost.spider.onion.core;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;

public interface Onionizer {
    ResolvedInstance onionise(Implementation impl, ResolvedInstance ref);
}
