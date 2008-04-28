package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;

public class DefaultAutoEdge<T> implements AutoEdge<T> {
    private final EdgeMethod invoker = new DefaultEdgeMethod();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Class<?> clazz;
    private final T target;
    private final MethodWarp warper;
    private final Method unedge;

    public DefaultAutoEdge(T target, MethodWarp warper) {
        this.target = target;
        this.clazz = target.getClass();
        this.warper = warper;
        this.unedge = classer.getDeclaredMethod(Edge.class, "unedge");
    }

    public Object invoke(Object proxy, Method src, Object[] args) {
        if (unedge.equals(src)) return unedge();
        Method trg = warper.warp(clazz, src);
        return invoker.invoke(trg, target, args);
    }

    public T unedge() {
        return target;
    }
}
