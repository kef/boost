package au.net.netstorm.boost.nursery.autoedge.utils;

import java.lang.reflect.Constructor;
import java.util.List;

import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.spider.instantiate.Nu;

public class DefaultConstructorFilter implements ConstructorFilter {
    FunctionalCollection collection;
    Object2ClassMapper mapper;
    Nu nu;

    public List<Constructor<?>> filter(Class<?> type, Object... params) {
        List<Class<?>> paramTypes = collection.map(params, mapper);
        CompatibleSignaturesFilter filter = nu.nu(DefaultCompatibleSignaturesFilter.class, paramTypes);
        Constructor<?>[] ctors = type.getConstructors();
        return collection.filter(ctors, filter);
    }
}
