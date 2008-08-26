package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.gunge.optional.Optional;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface ProvidersWirer {
    Providers nu(Optional<Provider> provider, InjectionSite root, Object[] args);
}
