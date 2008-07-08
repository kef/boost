package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

public interface GraphLifecycle {
    void build();

    void instantiate();

    void wire();

    void post();

    Object resolve();
}
