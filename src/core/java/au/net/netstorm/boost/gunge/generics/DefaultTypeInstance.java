package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// FIX 2328 this is an extremely naive type token, but can easily be expanded to support generic nuer

// FIX 2328 add ref to generic nuer story card

// FIX 2328 MAG Given the name of the public method should this class be called RawInstance?
public class DefaultTypeInstance implements TypeInstance {
    private final Class<?> type;

    public DefaultTypeInstance(ParameterizedType instance) {
        Type actual = actual(instance);
        type = build(actual);
    }

    private Type actual(ParameterizedType instance) {
        Type[] args = instance.getActualTypeArguments();
        if (args.length != 1) throw new IllegalArgumentException("Type tokens must only have a single type argument.");
        return args[0];
    }

    public Class<?> raw() {
        return type;
    }

    private Class<?> build(Type token) {
        if (token instanceof Class) return (Class<?>) token;
        if (token instanceof ParameterizedType) return raw((ParameterizedType) token);
        else throw new IllegalArgumentException("Type tokens only support Classes, ParameterizedTypes");
    }

    private Class<?> raw(ParameterizedType pType) {
        return (Class<?>) pType.getRawType();
    }
}
