package au.net.netstorm.boost.edge.guts;

// FIX 2328 implement me with logic dup in Unedger and validator and class warper
public interface EdgeMapper {
    String edgeToReal(String edge);
    String realToEdge(String edge);
}
