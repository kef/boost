package au.net.netstorm.boost.nursery.eight.legged.spider.provider.core;

import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;

// FIX 2328 provides an instance for an injection (may itself construct injections)
public interface Provider {
    // FIX 2328 other types of providers: instance (which could be reused to provide static edges)
    UnresolvedInstance nu(ResolvedInstance... args);
}
