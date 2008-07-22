package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

public interface StatefulGraph {
    void build();

    void instantiate();

    void wire();

    void post();

    Object resolve();
}
