package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.nursery.autoedge.utils.ConstructorResolver;

final class DefaultEdgeNu implements EdgeNu {
    ConstructorResolver resolver;
    EdgeConstructor constructor;
    Unedger unedger;

    public <T> T nu(Class<T> impl, Object... edgedArgs) {
        Constructor<T> c = resolver.resolve(impl, edgedArgs);
        Object[] realArgs = unedger.unedge(edgedArgs);
        return constructor.newInstance(c, realArgs);
    }
}
