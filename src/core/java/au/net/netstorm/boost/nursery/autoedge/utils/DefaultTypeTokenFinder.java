package au.net.netstorm.boost.nursery.autoedge.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DefaultTypeTokenFinder implements TypeTokenFinder {
    private final Class<?> target;
    private Type match;

    public DefaultTypeTokenFinder(Class<?> target) {
        this.target = target;
    }

    public boolean next(Type type) {
        if (!(type instanceof ParameterizedType)) return true;
        ParameterizedType pType = (ParameterizedType) type;
        if (pType.getRawType() == target) match = type;
        return match == null;
    }

    public Type result() {
        if (match == null) throw new RuntimeException("Could not find match");
        return match;
    }
}
