package au.net.netstorm.boost.nursery.eight.legged.spider.provider.types;

// FIX 2328 provides an instance for an injection (may itself construct injections)
public interface Provider {
    // FIX 2328 other types of providers: instance (which could be reused to provide static edges)
//    UnresolvedInstance nu(ResolvedInstance... args);
}
