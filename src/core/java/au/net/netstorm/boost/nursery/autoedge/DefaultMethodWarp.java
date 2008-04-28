package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public class DefaultMethodWarp implements MethodWarp {
    private final EdgeClass classer = new DefaultEdgeClass();
    public Method warp(Class<?> cls, Method src) {
        String name = src.getName();
        Class<?>[] params = src.getParameterTypes();
        return classer.getMethod(cls, name, params);
    }
}
