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
        if (realReturn != edgeReturn) {
            throw new IllegalArgumentException(
                    "Edge (" + edge + ") has invalid return type, must be (real or edge) " + realReturn);
        }
    }

    private Class<?> unedgedReturnType(Method edge) {
        Class<?> edgeReturn = edge.getReturnType();
        return unedger.unedge(edgeReturn);
    }
}
