package au.net.netstorm.boost.edge.guts;

public interface EdgeMapper {
    // FIX 2328 wire into Unedger and validator and class warper
    Class<?> staticEdgeToReal(Class<?> edge);
    Class<?> edgeToReal(Class<?> edge);
    Class<?> realToEdge(Class<?> real);
}
