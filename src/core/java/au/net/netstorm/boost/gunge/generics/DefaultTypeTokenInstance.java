package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// FIX 2328 this is an extremely naive type token, but can easily be expanded to support generic nuer
// FIX 2328 add ref to generic nuer story card
public class DefaultTypeTokenInstance implements TypeTokenInstance {
    private Class<?> type;

    public DefaultTypeTokenInstance(ParameterizedType instance) {
        Type[] args = instance.getActualTypeArguments();
        if (args.length != 1) throw new IllegalArgumentException("Type tokens must only have a single type argument.");
        buildTypeData(args[0]);
    }

    public Class<?> rawType() {
        return type;
    }

    private void buildTypeData(Type tokenType) {
        if (tokenType instanceof Class) build((Class<?>) tokenType);
        else if (tokenType instanceof ParameterizedType) build((ParameterizedType) tokenType);
        else throw new IllegalArgumentException("Type tokens only support Classes, ParameterizedTypes");
    }

    private void build(Class<?> cls) {
        type = cls;
    }

    private void build(ParameterizedType pType) {
        type = (Class<?>) pType.getRawType();
    }
}
