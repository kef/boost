package au.net.netstorm.boost.edge.guts;


// FIX 2328 wire in validator here instead of AutoEdger
// FIX 2328 this class is ordinary  revisit
public final class DefaultEdgeType implements EdgeType {
    private final Class<?> edge;
    private final Class<?> real;
    private final boolean staticy;
    private final EdgePackage edges;

    public DefaultEdgeType(Class<?> edge, Class<?> real, boolean staticy, EdgePackage edges) {
        this.edge = edge;
        this.real = real;
        this.staticy = staticy;
        this.edges = edges;
        validate();
    }

    public Class<?> getEdge() { return edge; }

    public Class<?> getReal() { return real; }

    public boolean isStaticEdge() { return staticy; }

    private void validate() {
        if (this.edge == null || this.real == null)  throw new IllegalArgumentException();
        String expectedEdgeName = expectedEdgeName();
        String edgeName = edge.getName();
        if (!edgeName.equals(expectedEdgeName)) fail(expectedEdgeName, edgeName);
    }

    // FIX 2328 possible dup in class warper - kind of (inverse) - may be able to pull out
    private String expectedEdgeName() {
        String realName = real.getName();
        String prefix = edges.prefix() + ".";
        String suffix = staticy ? "Static" : "";
        String expectedEdgeName = prefix + realName + suffix;
        return expectedEdgeName;
    }

    private void fail(String expected, String actual) {
        throw new IllegalArgumentException("Invalid edge, expected " + expected + " got " + actual);
    }
}
