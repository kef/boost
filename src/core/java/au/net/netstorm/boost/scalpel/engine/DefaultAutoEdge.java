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
    private final Method equals;
    private final Method hashCode;
    MethodWarp warper;
    Unedger unedger;
    ReturnEdger returnEdger;

    // FIX 2328 change this to accept an edge method factory rather than a realClass
    public <R> DefaultAutoEdge(Class<R> realClass, R real) {
        this.real = real;
        this.realClass = realClass;
        this.unedge = method(Unedgable.class, "unedge");
        this.equals = method(Object.class, "equals", Object.class);
        this.hashCode = method(Object.class, "hashCode");
    }

    public Object invoke(Method edgeMethod, Object[] edgedArgs) {
        if (unedge.equals(edgeMethod)) return real;
        Method realMethod = warper.warp(realClass, edgeMethod);
        Object target = target(realMethod);
        Object[] realArgs = unedger.unedge(edgedArgs);
        Object realReturn = realMethod.invoke(target, realArgs);
        return returnEdger.edge(edgeMethod, realReturn);
    }

    // FIX 2394 This is untidy. What operations should static edges support?
    // FIX 2394 Equals and hashCode required for primordial.
    // FIX 2394 This also makes me think an object is required for real which some of these operations are pushed to.
    private Object target(Method method) {
        if (real != null) return real;
        if (method.equals(equals)) return this;
        if (method.equals(hashCode)) return this;
        return real;
    }

    private Method method(Class cls, String name, Class... args) {
        java.lang.reflect.Method method = classer.getMethod(cls, name, args);
        return new DefaultMethod(method);
    }
}
