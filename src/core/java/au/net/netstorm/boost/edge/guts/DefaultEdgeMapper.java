package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;

// FIX 2328 another case for the exception handling strategy
public final class DefaultEdgeMapper implements EdgeMapper {
    EdgeClass classer;
    EdgeNameMapper mapper;

    public Class<?> edgeToReal(Class<?> edge) {
        String edgeName = edge.getName();
        String realName = mapper.edgeToReal(edgeName);
        return classer.forName(realName);
    }

    public Class<?> staticEdgeToReal(Class<?> edge) {
        String edgeName = edge.getName();
        String realName = mapper.staticEdgeToReal(edgeName);
        return classer.forName(realName);
    }

    public Class<?> realToEdge(Class<?> real) {
        String realName = real.getName();
        String edgeName = mapper.realToEdge(realName);
        return classer.forName(edgeName);
    }
}
