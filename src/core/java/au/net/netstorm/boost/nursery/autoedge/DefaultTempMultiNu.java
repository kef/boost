package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.nursery.autoedge.utils.ConstructorResolver;

public final class DefaultTempMultiNu implements TempMultiNu {
    ConstructorResolver resolver;
    EdgeConstructor constructor;

    public <T> T nu(Class<T> impl, Object... args) {
        Constructor<T> c = resolver.resolve(impl, args);
        // TODO unedge args
        return constructor.newInstance(c, args);
    }
}
