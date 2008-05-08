package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.core.Edge;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;
import au.net.netstorm.boost.gunge.reflect.ConstructorResolver;

import java.lang.reflect.Constructor;

final class DefaultRealNu implements RealNu {
    ConstructorResolver resolver;
    EdgeConstructor constructor;
    TypeResolver typeResolver;
    Unedger unedger;

    @SuppressWarnings("unchecked")
    public <E extends Edge<R>, R> R nu(Class<E> edge, Object... edgedArgs) {
        TypeInstance typeToken = typeResolver.resolve(edge, Edge.class);
        Class<?> type = typeToken.raw();
        Constructor<?> c = resolver.resolve(type, edgedArgs);
        Object[] realArgs = unedger.unedge(edgedArgs);
        return (R) constructor.newInstance(c, realArgs);
    }
}
