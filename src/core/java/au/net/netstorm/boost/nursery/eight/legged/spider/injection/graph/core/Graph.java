package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

public interface Graph {
    void build();

    void instantiate();

    void wire();

    void post();

    Object resolve();
}
