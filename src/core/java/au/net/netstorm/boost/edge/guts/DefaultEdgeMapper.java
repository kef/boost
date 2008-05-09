package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.gunge.string.StringTransform;

public class DefaultEdgeMapper implements EdgeMapper {
    EdgePackage edges;
    StringTransform transformer;

    public String staticEdgeToReal(String staticEdge) {
        String edge = transformer.stripSuffix(staticEdge, "Static");
        return edgeToReal(edge);
    }

    public String edgeToReal(String edge) {
        String prefix = edges.prefix() + ".";
        return transformer.stripPrefix(edge, prefix);
    }

    public String realToEdge(String real) {
        return edges.prefix() + "." + real;
    }
}
