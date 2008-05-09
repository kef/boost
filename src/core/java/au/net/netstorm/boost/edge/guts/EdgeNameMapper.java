package au.net.netstorm.boost.edge.guts;

public interface EdgeNameMapper {
    // FIX 2328 wire into Unedger and validator and class warper
    String staticEdgeToReal(String edge);
    String edgeToReal(String edge);
    String realToEdge(String real);
}
