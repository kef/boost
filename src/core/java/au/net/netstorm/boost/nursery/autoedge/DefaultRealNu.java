package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;
import au.net.netstorm.boost.nursery.autoedge.utils.ConstructorResolver;

final class DefaultRealNu implements RealNu {
    ConstructorResolver resolver;
    EdgeConstructor constructor;
    TypeResolver typeResolver;
    Unedger unedger;

    @SuppressWarnings("unchecked")
    public <E extends Edge<R>, R> R nu(Class<E> edge, Object... edgedArgs) {
        TypeInstance typeToken = typeResolver.resolve(edge, Edge.class);
        Class<?> type = typeToken.rawType();
        Constructor<?> c = resolver.resolve(type, edgedArgs);
        Object[] realArgs = unedger.unedge(edgedArgs);
        return (R) constructor.newInstance(c, realArgs);
    }
}
