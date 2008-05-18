package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;

import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;

// FIX 2328 wire into DefaultAutoEdge
final class DefaultEdgedMethods implements EdgedMethods {
    private final StrictMap<Method, Method> methods = new DefaultStrictMap();
    public DefaultEdgedMethods(Class<?> edge, Class<?> real, MethodWarp warper) {
        for (Method e : edge.getDeclaredMethods()) {
            Method r = warper.warp(real, e);
            methods.put(e, r);
        }
     }

    public Method lookup(Method edge) {
        return methods.get(edge);
    }
}
