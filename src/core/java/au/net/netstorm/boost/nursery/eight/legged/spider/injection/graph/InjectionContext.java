package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

public interface InjectionContext {
    boolean hasRef(Injection injection);

    Object ref(Injection injection);

    void put(Injection injection, Object ref);
}
