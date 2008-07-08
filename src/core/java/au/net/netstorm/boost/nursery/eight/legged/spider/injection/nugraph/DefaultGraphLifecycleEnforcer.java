package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

public final class DefaultGraphLifecycleEnforcer implements GraphLifecycleEnforcer {
    public Object apply(GraphLifecycle graph) {
        graph.build();
        graph.instantiate();
        graph.wire();
        graph.post();
        return graph.resolve();
    }
}
