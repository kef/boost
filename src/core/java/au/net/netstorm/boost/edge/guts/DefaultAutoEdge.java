package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Method;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeMethod;

final class DefaultAutoEdge implements AutoEdge {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Object real;
    private final Class<?> realClass;
    private final Method unedge;
    MethodWarp warper;
    EdgeMethod invoker;
    Unedger unedger;
    ReturnEdger returnEdger;

    public <R> DefaultAutoEdge(Class<R> realClass, R real) {
        this.real = real;
        this.realClass = realClass;
        this.unedge = classer.getDeclaredMethod(Unedgable.class, "unedge");
    }

    public Object invoke(Object edge, Method edgeMethod, Object[] edgedArgs) {
        if (unedge.equals(edgeMethod)) return real;
        Method realMethod = warper.warp(realClass, edgeMethod);
        Object[] realArgs = unedger.unedge(edgedArgs);
        Object realReturn = invoker.invoke(realMethod, real, realArgs);
        return returnEdger.edge(edgeMethod, realReturn);
    }
}
