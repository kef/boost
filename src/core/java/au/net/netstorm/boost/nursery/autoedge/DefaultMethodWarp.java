package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;

final class DefaultMethodWarp implements MethodWarp {
    EdgeClass classer;
    TypeTokenResolver typeResolver;

    public Method warp(Class<?> real, Method edge) {
        String name = edge.getName();
        Class<?>[] params = edge.getParameterTypes();
        unedge(params);
        return classer.getMethod(real, name, params);
    }

    private void unedge(Class<?>[] params) {
        for (int i = 0; i < params.length; ++i) {
            params[i] = unedge(params[i]);
        }
    }

    private Class<?> unedge(Class<?> cls) {
        if (!Edge.class.isAssignableFrom(cls)) return cls;
        TypeTokenInstance typeToken = typeResolver.resolve(Edge.class, cls);
        return typeToken.rawType();
    }
}
