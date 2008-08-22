package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.scalpel.core.Unedgable;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

final class DefaultAutoEdge implements AutoEdge {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Object real;
    private final Class<?> realClass;
    private final Method unedge;
    MethodWarp warper;
    Unedger unedger;
    ReturnEdger returnEdger;

    // FIX 2328 change this to accept an edge method factory rather than a realClass
    public <R> DefaultAutoEdge(Class<R> realClass, R real) {
        this.real = real;
        this.realClass = realClass;
        this.unedge = unedge();
    }

    public Object invoke(Method edgeMethod, Object[] edgedArgs) {
        if (unedge.equals(edgeMethod)) return real;
        // FIX 2328 bad bug here, handle inherited instance methods for static edges
        Method realMethod = warper.warp(realClass, edgeMethod);
        Object[] realArgs = unedger.unedge(edgedArgs);
        Object realReturn = realMethod.invoke(real, realArgs);
        return returnEdger.edge(edgeMethod, realReturn);
    }

    private Method unedge() {
        java.lang.reflect.Method method = classer.getDeclaredMethod(Unedgable.class, "unedge");
        return new DefaultMethod(method);
    }
}
