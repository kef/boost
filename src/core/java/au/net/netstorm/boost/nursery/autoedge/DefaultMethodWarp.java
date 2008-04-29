package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultMethodWarp implements MethodWarp {
    EdgeClass classer;

    public Method warp(Class<?> cls, Method src) {
        String name = src.getName();
        Class<?>[] params = src.getParameterTypes();
        return classer.getMethod(cls, name, params);
    }
}
