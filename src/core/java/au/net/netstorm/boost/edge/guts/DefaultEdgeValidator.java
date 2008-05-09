package au.net.netstorm.boost.edge.guts;


final class DefaultEdgeValidator implements EdgeValidator {
    EdgeNameMapper mapper;

    public void validate(Class<?> edge, Class<?> real, boolean staticy) {
        String edgeName = edge.getName();
        String realName = real.getName();
        String expectedEdgeName = staticy ? mapper.realToStaticEdge(realName) : mapper.realToEdge(realName);
        validateName(edgeName, expectedEdgeName);
    }

    private void validateName(String edgeName, String expectedEdgeName) {
        if (!expectedEdgeName.equals(edgeName)) {
            throw new IllegalArgumentException("Invalid edge, expected " + expectedEdgeName + " got " + edgeName);
        }
    }
}
