package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface ResolverEngine {
    ResolvedInstance resolve(Interface iface);

    ResolvedInstance resolve(Implementation impl);
}
