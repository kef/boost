package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.bullet.primordial.Primordial;

// FIX 2328 wire in validator here instead of AutoEdger
public final class DefaultEdgeType extends Primordial implements EdgeType {
    private final Class<?> edge;
    private final Class<?> real;

    public DefaultEdgeType(Class<?> edge, Class<?> real) {
        this.edge = edge;
        this.real = real;
        validate();
    }

    public Class<?> getEdge() { return edge; }

    public Class<?> getReal() { return real; }

    private void validate() {
        if (this.edge == null || this.real == null) throw new IllegalArgumentException();
    }
}
