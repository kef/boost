package au.net.netstorm.boost.spider.newer.assembly;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.util.type.Interface;

public interface NewerAssembler {
    Newer assemble(Interface type, ProviderEngine provider);
}
