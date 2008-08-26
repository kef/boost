package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.protocol;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.gunge.optional.Optional;

public interface ProtocolInstanceWirer {
    ProtocolInstance nu(InjectionSite root, Optional<Provider> provider, Object[] args);
}
