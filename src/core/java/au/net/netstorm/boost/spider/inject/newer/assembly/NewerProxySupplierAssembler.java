package au.net.netstorm.boost.spider.inject.newer.assembly;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.inject.newer.core.NewerProxySupplier;

public interface NewerProxySupplierAssembler {
    NewerProxySupplier assemble(ProviderEngine providerEngine);
}
