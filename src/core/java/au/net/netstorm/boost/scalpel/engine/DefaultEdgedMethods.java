package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;
// FIX BREADCRUMB 2328 implement me
final class DefaultEdgedMethods implements EdgedMethods {
    public DefaultEdgedMethods(Class<?> edge, Class<?> real) {
    }

    public Method unedge(Method edge) {
        throw new UnsupportedOperationException();
    }
}
