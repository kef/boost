package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;

public final class DefaultAutoEdge<T> implements AutoEdge<T> {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Class<?> clazz;
    private final T target;
    private final Method unedge;
    MethodWarp warper;
    EdgeMethod invoker;

    public DefaultAutoEdge(T target) {
        this.target = target;
        this.clazz = target.getClass();
        this.unedge = classer.getDeclaredMethod(Edge.class, "unedge");
    }

    public Object invoke(Object proxy, Method src, Object[] args) {
        if (unedge.equals(src)) return unedge();
        Method trg = warper.warp(clazz, src);
        unedge(args);
        Object result = invoker.invoke(trg, target, args);
        return edge(result);
    }

    public T unedge() {
        return target;
    }

    private Object edge(Object unedged) {
        // TODO edge return values
        return unedged;
    }

    // FIXME abstract this out, required in nuer as well
    private void unedge(Object[] args) {
        if (args == null) return;
        for (int i = 0; i < args.length; ++i) {
            if (args[i] instanceof Edge) {
                Edge<?> edge = (Edge<?>) args[i];
                args[i] = edge.unedge();
            }
        }
    }

}
