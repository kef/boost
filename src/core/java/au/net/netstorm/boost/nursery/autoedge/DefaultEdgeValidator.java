package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;


final class DefaultEdgeValidator implements EdgeValidator {
    TypeTokenResolver typeResolver;

    public void validate(Class<?> edge) {
        TypeTokenInstance typeToken = typeResolver.resolve(Edge.class, edge);
        Class<?> real = typeToken.rawType();

        validateSameSimpleName(edge, real);
        validatePackageName(edge, real);
    }

    public void validateSameSimpleName(Class<?> edge, Class<?> real) {
        String edgeName = edge.getSimpleName();
        String realName = real.getSimpleName();
        String validName = isStaticEdge(edge) ? realName + StaticEdge.SUFFIX : realName;
        if (!edgeName.equals(validName)) fail(edge);
    }

    public void validatePackageName(Class<?> edge, Class<?> real) {
        String edgeName = packageName(edge);
        String realName = packageName(real);
        if (!edgeName.endsWith(realName)) fail(edge);
    }

    private boolean isStaticEdge(Class<?> edge) {
        return StaticEdge.class.isAssignableFrom(edge);
    }

    private String packageName(Class<?> c) {
        Package packager = c.getPackage();
        return packager.getName();
    }

    private void fail(Class<?> edge) {
        throw new IllegalArgumentException(
                "Invalid edge class, edges must implement Edge<RawType> or StaticEdge<RawType>" +
                "and use a mirrored package structure.");
    }
}
