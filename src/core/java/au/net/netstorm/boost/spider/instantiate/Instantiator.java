package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public interface Instantiator {
    UnresolvedInstance instantiate(Implementation impl, Object[] parameters);
}
