package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.gunge.optional.Optional;

public interface GraphLifecycleEnforcer {
    Object apply(InjectionType type, Optional<Provider> provider, Object... args);
}
