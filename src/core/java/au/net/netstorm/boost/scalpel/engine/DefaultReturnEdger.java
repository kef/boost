package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

import au.net.netstorm.boost.scalpel.core.AutoEdger;
import au.net.netstorm.boost.scalpel.core.Edge;

final class DefaultReturnEdger implements ReturnEdger {
    AutoEdger edger;

    @SuppressWarnings("unchecked")
    public Object edge(Method edgeMethod, Object realReturn) {
        Class<?> realType = edgeMethod.getReturnType();
        return edge(realType, realReturn);
    }

    private Object edge(Class<?> realType, Object realReturn) {
        if (realType.isArray()) return edgeArray(realType, realReturn);
        if (!isEdge(realType)) return realReturn;
        Class<Edge> edgeType = (Class<Edge>) realType;
        return edger.edge(edgeType, realReturn);
    }

    private Object edgeArray(Class<?> array, Object real) {
        Class<?> realType = array.getComponentType();
        Object[] realReturn = (Object[]) real;
        Object[] edgeReturn = (Object[]) Array.newInstance(realType, realReturn.length);
        for (int i = 0; i < realReturn.length; ++i) {
            edgeReturn[i] = edge(realType, realReturn[i]);
        }
        return edgeReturn;
    }

    private boolean isEdge(Class<?> realType) {
        return Edge.class.isAssignableFrom(realType);
    }
}
