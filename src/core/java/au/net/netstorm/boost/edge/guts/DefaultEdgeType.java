package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultEdgeType extends Primordial implements EdgeType {
    private final Class<?> edge;
    private final Class<?> real;

    public DefaultEdgeType(Class<?> edge, Class<?> real) {
        this.edge = edge;
        this.real = real;
        if (this.edge == null || this.real == null) throw new IllegalArgumentException();
    }

    public Class<?> getEdge() { return edge; }

    public Class<?> getReal() { return real; }
}
