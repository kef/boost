package au.net.netstorm.boost.scalpel.guts;

interface EdgeNameMapper {
    String edgeToReal(String edge);

    String staticEdgeToReal(String edge);

    String realToEdge(String real);

    String realToStaticEdge(String real);
}
