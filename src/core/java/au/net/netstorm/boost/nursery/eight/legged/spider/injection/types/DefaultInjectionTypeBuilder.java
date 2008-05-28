package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

public final class DefaultInjectionTypeBuilder implements InjectionTypeBuilder {
    public InjectionType build(Type type) {
        if (type instanceof Class) return raw(type);
        if (type instanceof ParameterizedType) return paramertized(type);
        throw new IllegalArgumentException(
                "Type not supported. Declarations, Wildcards and Arrays can not be injected," + 
                "must be one of [Class, ParameterizedType]");
    }

    private InjectionType raw(Type type) {
        Class<?> raw = (Class<?>) type;
        return new DefaultInjectionType(raw);
    }

    // FIX 2394 add support for parameterized types
    private InjectionType paramertized(Type type) {
        ParameterizedType parameterized = (ParameterizedType) type;
        Type raw = parameterized.getRawType();
        return raw(raw);
    }
}
