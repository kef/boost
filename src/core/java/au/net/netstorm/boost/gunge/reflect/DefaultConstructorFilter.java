package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;
import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.nursery.type.core.Types;

public class DefaultConstructorFilter implements ConstructorFilter {
    FunctionalCollection collection;
    Object2ClassMapper mapper;
    Types types;

    public List<Constructor<?>> filter(Class<?> type, Object... params) {
        List<Class<?>> paramTypes = collection.map(params, mapper);
        CompatibleSignaturesFilter filter = types.nu(CompatibleSignaturesFilter.class, paramTypes);
        Constructor<?>[] ctors = type.getConstructors();
        return collection.filter(ctors, filter);
    }
}
