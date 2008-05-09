package au.net.netstorm.boost.edge.guts;

// FIX 2328 implement me with logic dup in Unedger and validator and class warper

// FIX 2328 rename to EdgeNameMapper
public interface EdgeNameMapper {
    // FIX 2328 wire in
    String staticEdgeToReal(String edge);
    String edgeToReal(String edge);
    String realToEdge(String real);
}
