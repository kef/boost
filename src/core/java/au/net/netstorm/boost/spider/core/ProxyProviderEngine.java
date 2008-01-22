package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface ProxyProviderEngine {
    ResolvedInstance provide(Implementation impl, Object[] params);

    ResolvedInstance provide(Interface iface, Implementation impl, Object[] params, Class<? extends Layer>... layers);
}
