package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;

// FIX 2328 another case for the exception handling strategy
public final class DefaultEdgeMapper implements EdgeMapper {
    EdgeClass classer;
    EdgeNameMapper mapper;

    public Class<?> edgeToReal(Class<?> edge) {
        String edgeName = edge.getName();
        String realName = mapper.edgeToReal(edgeName);
        return findClass(edge, realName);
    }

    public Class<?> staticEdgeToReal(Class<?> edge) {
        String edgeName = edge.getName();
        String realName = mapper.staticEdgeToReal(edgeName);
        return findClass(edge, realName);
    }

    private Class<?> findClass(Class<?> edge, String name) {
        try {
            return classer.forName(name);
        } catch (EdgeException e) {
            throw new IllegalArgumentException("Real class (" + name + ") not found for edge: " + edge);
        }
    }
}
