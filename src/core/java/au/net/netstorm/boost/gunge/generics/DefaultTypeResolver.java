package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.Type;
import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.nursery.type.core.Types;

// FIX 2328 Consider a specific exception which does some lovely toStringing.

// FIX 2328 Not sure.  Discuss.
public final class DefaultTypeResolver implements TypeResolver {
    FunctionalCollection collection;
    Types types;

    public TypeInstance resolve(Class<?> token, Class<?>... tokenInterfaces) {
        Class<?> tokenInterface = match(token, tokenInterfaces);
        return find(token, tokenInterface);
    }

    private Class<?> match(Class<?> token, Class<?>... ifaces) {
        for (Class<?> iface : ifaces) {
            if (iface.isAssignableFrom(token)) return iface;
        }
        throw new RuntimeException("Can not resolve type from token.");
    }

    private TypeInstance find(Class<?> token, Class<?> iface) {
        Type[] interfaces = token.getGenericInterfaces();
        TypeTokenFinder finder = types.nu(TypeTokenFinder.class, iface);
        Type instance = collection.find(interfaces, finder);
        return types.nu(TypeInstance.class, instance);
    }
}
