package au.net.netstorm.boost.edge.guts;


final class DefaultEdgeValidator implements EdgeValidator {
    EdgePackage edges;

    public void validate(Class<?> edge, Class<?> real, boolean staticy) {
        String expectedEdgeName = expectedEdgeName(real, staticy);
        String edgeName = edge.getName();
        if (!expectedEdgeName.equals(edgeName)) fail(expectedEdgeName, edgeName);
    }

    private String expectedEdgeName(Class<?> real, boolean staticy) {
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
