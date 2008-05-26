package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

// FIX 2394 not quite sure about this yet, may not want to accept args in apply()
public interface RootInjection {
    void build(); 
    Object apply(Object... args);
}
