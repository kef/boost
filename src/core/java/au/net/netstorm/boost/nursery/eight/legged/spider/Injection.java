package au.net.netstorm.boost.nursery.eight.legged.spider;

// FIX 2328 injection graph node, does the actual injection using a provider
public interface Injection {
    Object apply(InjectionContext ctx, Object... args);
}
