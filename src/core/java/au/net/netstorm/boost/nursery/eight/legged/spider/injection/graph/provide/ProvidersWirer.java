package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.gunge.optional.Optional;

// FIX 2394 use or lose. wire into StatefulGraphWirer.
public interface ProvidersWirer {
    Providers nu(Instances instances, Optional<Provider> provider, InjectionSite root, Object[] args);
}
