package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;

import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;

// FIX BREADCRUMB 2328 implement me
final class DefaultEdgedMethods implements EdgedMethods {
    // FIX 2328 bad 
    private final StrictMap<Method, Method> methods = new DefaultStrictMap<Method, Method>();
    public DefaultEdgedMethods(Class<?> edge, Class<?> real) {
    }

    public Method unedge(Method edge) {
        throw new UnsupportedOperationException();
    }
}
