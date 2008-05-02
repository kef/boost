package au.net.netstorm.boost.nursery.autoedge.utils;

import java.lang.reflect.Constructor;
import java.util.List;

public class DefaultCompatibleSignaturesFilter implements CompatibleSignaturesFilter {
    private final Class<?>[] specificTypes;
    MethodSignatureRules jls;

    public DefaultCompatibleSignaturesFilter(List<Class<?>> specificTypes) {
        this.specificTypes = specificTypes.toArray(new Class[specificTypes.size()]);
    }

    public boolean accept(Constructor<?> c) {
        Class<?>[] candidate = c.getParameterTypes();
        return jls.compatible(candidate, specificTypes);
    }
}
