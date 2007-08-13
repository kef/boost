package au.net.netstorm.boost.spider.newer.assembly;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.newer.core.NewerProxySupplier;

public interface NewerProxySupplierAssembler {
    NewerProxySupplier assemble(ProviderEngine providerEngine);
}
