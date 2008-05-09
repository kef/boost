package au.net.netstorm.boost.edge.guts;

public interface EdgeNameMapper {
    String staticEdgeToReal(String edge);
    String edgeToReal(String edge);
    String realToEdge(String real);
}
