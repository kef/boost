package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;

final class DefaultAutoEdge implements AutoEdge {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Object real;
    private final Class<?> realClass;
    private final Method unedge;
    MethodWarp warper;
    EdgeMethod invoker;
    AutoEdger edger;
    Unedger unedger;

    public DefaultAutoEdge(Object real) {
        this.real = real;
        this.realClass = real.getClass();
        this.unedge = classer.getDeclaredMethod(Edge.class, "unedge");
    }

    public Object invoke(Object edge, Method edgeMethod, Object[] edgedArgs) {
        if (unedge.equals(edgeMethod)) return real;
        Method realMethod = warper.warp(realClass, edgeMethod);
        Object[] realArgs = unedger.unedge(edgedArgs);
        Object realReturn = invoker.invoke(realMethod, real, realArgs);
        return edgeReturn(edgeMethod, realReturn);
    }

    @SuppressWarnings("unchecked")
    private Object edgeReturn(Method edgeMethod, Object realReturn) {
        Class<?> realType = edgeMethod.getReturnType();
        if (!Edge.class.isAssignableFrom(realType)) return realReturn;
        Class<Edge> edgeType = (Class<Edge>) realType;
        return edger.edge(edgeType, realReturn);
    }
}
