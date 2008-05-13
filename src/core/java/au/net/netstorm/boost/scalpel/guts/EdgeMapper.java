package au.net.netstorm.boost.scalpel.guts;

public interface EdgeMapper {
    Class<?> staticEdgeToReal(Class<?> edge);

    Class<?> edgeToReal(Class<?> edge);
}
