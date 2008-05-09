package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.gunge.reflect.ConstructorResolver;

final class DefaultRealNu implements RealNu {
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
