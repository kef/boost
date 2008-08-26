package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.protocol;

public interface ProtocolInstance {
    void build();

    void wire();

    void post();

    Object resolve();
}
