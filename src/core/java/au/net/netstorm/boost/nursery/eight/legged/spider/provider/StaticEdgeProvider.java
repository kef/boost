package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import au.net.netstorm.boost.scalpel.core.AutoEdger;
import au.net.netstorm.boost.scalpel.core.Edge;

public final class StaticEdgeProvider implements Provider {
    private final Class<Edge> edge;
    AutoEdger edger;

    public StaticEdgeProvider(Class<Edge> edge) {
        this.edge = edge;
    }

    public Object nu(Object... args) {
        if (args.length != 0) throw new IllegalArgumentException();
        return edger.edge(edge);
    }
}
