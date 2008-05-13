package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.gunge.reflect.ConstructorResolver;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeConstructor;

public final class DefaultRealNu implements RealNu {
    ConstructorResolver resolver;
    EdgeConstructor constructor;
    Unedger unedger;

    public <R> R nu(Class<R> realClass, Object... edgedArgs) {
        Constructor<?> c = resolver.resolve(realClass, edgedArgs);
        Object[] realArgs = unedger.unedge(edgedArgs);
        Object real = constructor.newInstance(c, realArgs);
        return realClass.cast(real);
    }
}
