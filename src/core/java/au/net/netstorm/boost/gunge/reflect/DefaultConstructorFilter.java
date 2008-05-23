package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;
import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.spider.core.Nu;

public class DefaultConstructorFilter implements ConstructorFilter {
    FunctionalCollection collection;
    ObjectToClassMapper mapper;
    Nu nu;

    public List<Constructor<?>> filter(Class<?> type, Object... params) {
        List<Class<?>> paramTypes = collection.map(params, mapper);
        CompatibleSignaturesFilter filter = nu.nu(CompatibleSignaturesFilter.class, paramTypes);
        Constructor<?>[] ctors = type.getConstructors();
        return collection.filter(ctors, filter);
    }
}
