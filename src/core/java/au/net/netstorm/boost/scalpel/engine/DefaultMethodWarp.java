package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;

import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

final class DefaultMethodWarp implements MethodWarp {
    EdgeClass classer;
    Unedger unedger;

    public Method warp(Class<?> real, Method edge) {
        String name = edge.getName();
        Class<?>[] edgeParams = edge.getParameterTypes();
        Class<?>[] realParams = unedger.unedge(edgeParams);
        Method r = classer.getMethod(real, name, realParams);
        validate(r, edge);
        return r;
    }

    private void validate(Method real, Method edge) {
        Class<?> realReturn = real.getReturnType();
        Class<?> edgeReturn = unedgedReturnType(edge);
        if (edgeReturn == void.class) return;
        if (realReturn == edgeReturn) return;
        if (isEdgeArray(realReturn, edgeReturn)) return;
        throw new IllegalArgumentException("Edge method \"" + edge +
                "\" has invalid return type, must be (real or edge) variant of \""
                + realReturn + "\".  Instead it is \"" + edgeReturn + "\".");
    }

    private boolean isEdgeArray(Class<?> realOf, Class<?> edgeOf) {
        if (!realOf.isArray()) return false;
        if (!edgeOf.isArray()) return false;
        return recursiveIsEdgeArray(realOf, edgeOf);
    }

    private boolean recursiveIsEdgeArray(Class<?> real, Class<?> edge) {
        Class<?> realOf = real.getComponentType();
        Class<?> edgeOf = real.getComponentType();
        if (isEdgeArray(realOf, edgeOf)) return true;
        return realOf.equals(edgeOf);
    }

    private Class<?> unedgedReturnType(Method edge) {
        Class<?> edgeReturn = edge.getReturnType();
        return unedger.unedge(edgeReturn);
    }
}
