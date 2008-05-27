package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

// FIX 2328 injection graph node, does the actual injection using a provider
public interface Injection {
    void build(); 
    Object apply(InjectionContext ctx);
}
