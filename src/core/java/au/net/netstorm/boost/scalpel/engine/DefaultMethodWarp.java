package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

import java.lang.reflect.Method;

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
        if (edgeReturn != void.class && realReturn != edgeReturn) fail(edge, realReturn, edgeReturn);
    }

    private void fail(Method edge, Class<?> realReturn, Class<?> edgeReturn) {
        throw new IllegalArgumentException("Edge method \"" + edge +
                "\" has invalid return type, must be (real or edge) variant of \"" +
                realReturn + "\".  Instead it is \"" + edgeReturn + "\".");
    }

    private Class<?> unedgedReturnType(Method edge) {
        Class<?> edgeReturn = edge.getReturnType();
        return unedger.unedge(edgeReturn);
    }
}
