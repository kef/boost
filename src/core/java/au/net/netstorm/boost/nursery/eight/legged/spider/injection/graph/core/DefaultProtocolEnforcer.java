package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

public final class DefaultProtocolEnforcer implements ProtocolEnforcer {
    public Object apply(ProtocolInstance protocol) {
        protocol.build();
        protocol.wire();
        protocol.post();
        return protocol.resolve();
    }
}
