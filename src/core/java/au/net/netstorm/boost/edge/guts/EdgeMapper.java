package au.net.netstorm.boost.edge.guts;

public interface EdgeMapper {
    Class<?> staticEdgeToReal(Class<?> edge);
    Class<?> edgeToReal(Class<?> edge);
}
