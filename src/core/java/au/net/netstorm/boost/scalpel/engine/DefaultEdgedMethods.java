package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;
import au.net.netstorm.boost.spider.flavour.StrictMap;

// FIX 2328 wire into DefaultAutoEdge
final class DefaultEdgedMethods implements EdgedMethods {
    private final StrictMap<Method, Method> methods = new DefaultStrictMap();

    public DefaultEdgedMethods(Class<?> edge, Class<?> real, MethodWarp warper) {
        Method[] edgeMethods = methods(edge);
        for (Method e : edgeMethods) {
            Method r = warper.warp(real, e);
            methods.put(e, r);
        }
    }

    // FIX 2130 Sort out a consistent approach for edging/deedging DefaultMethod.  See also AutoEdge.unedge().
    private Method[] methods(Class edge) {
        java.lang.reflect.Method[] edgies = edge.getDeclaredMethods();
        Method[] result = new Method[edgies.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new DefaultMethod(edgies[i]);
        }
        return result;
    }

    public Method lookup(Method edge) {
        return methods.get(edge);
    }
}
