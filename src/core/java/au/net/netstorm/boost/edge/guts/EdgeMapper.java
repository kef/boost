package au.net.netstorm.boost.edge.guts;

public interface EdgeMapper {
    // FIX 2328 wire into and validator
    Class<?> staticEdgeToReal(Class<?> edge);
    Class<?> edgeToReal(Class<?> edge);
    Class<?> realToEdge(Class<?> real);
}
