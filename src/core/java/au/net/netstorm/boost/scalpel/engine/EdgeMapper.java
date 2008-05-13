package au.net.netstorm.boost.scalpel.engine;

public interface EdgeMapper {
    Class<?> staticEdgeToReal(Class<?> edge);

    Class<?> edgeToReal(Class<?> edge);
}
