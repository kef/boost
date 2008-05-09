package au.net.netstorm.boost.edge.guts;

// FIX 2328 implement me with logic dup in Unedger and validator and class warper

// FIX 2328 rename to EdgeNameMapper
public interface EdgeMapper {
    // FIX 2328 wire in
    String edgeToReal(String edge, boolean staticy);
    String realToEdge(String real, boolean staticy);
}
