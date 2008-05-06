package au.net.netstorm.boost.edge;

final class DefaultEdgeValidator implements EdgeValidator {
    public void validate(Class<?> edge, Class<?> real) {
        validateSameSimpleName(edge, real);
        validatePackageName(edge, real);
    }

    public void validateSameSimpleName(Class<?> edge, Class<?> real) {
        String edgeName = edge.getSimpleName();
        String realName = real.getSimpleName();
        String validName = isStaticEdge(edge) ? realName + "Static" : realName;
        if (!edgeName.equals(validName)) fail();
    }

    public void validatePackageName(Class<?> edge, Class<?> real) {
        String edgeName = packageName(edge);
        String realName = packageName(real);
        if (!edgeName.endsWith(realName)) fail();
    }

    private boolean isStaticEdge(Class<?> edge) {
        return StaticEdge.class.isAssignableFrom(edge);
    }

    private String packageName(Class<?> c) {
        Package packager = c.getPackage();
        return packager.getName();
    }

    private void fail() {
        throw new IllegalArgumentException(
                "Invalid edge class, edges must implement Edge<RawType> or StaticEdge<RawType>" +
                        "and use a mirrored package structure.");
    }
}
