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
        if (!edgeName.equals(realName)) fail();
    }

    public void validatePackageName(Class<?> edge, Class<?> real) {
        String edgeName = edge.getName();
        String realName = real.getName();
        if (!edgeName.endsWith(realName)) fail();
    }

    private void fail() {
        throw new IllegalArgumentException(
                "Invalid edge class, edges must implement Edge<RawType> and use a mirrored package structure.");
    }
}
