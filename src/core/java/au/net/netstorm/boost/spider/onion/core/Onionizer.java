package au.net.netstorm.boost.spider.onion.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Onionizer {
    ResolvedInstance onionise(Implementation impl, ResolvedInstance ref);
}
