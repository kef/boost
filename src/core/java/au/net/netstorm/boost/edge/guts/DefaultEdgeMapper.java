package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.gunge.string.StringTransform;

public class DefaultEdgeMapper implements EdgeMapper {
    EdgePackage edges;
    StringTransform transformer;

    public String edgeToReal(String edge, boolean staticy) {
        String prefix = edges.prefix() + ".";
        return transformer.stripPrefix(edge, prefix);
    }

    public String realToEdge(String real, boolean staticy) {
        return edges.prefix() + "." + real;
    }
}
