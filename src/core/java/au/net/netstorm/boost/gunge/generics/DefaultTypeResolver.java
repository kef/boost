package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.Type;
import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultTypeResolver implements TypeResolver {
    FunctionalCollection collections;
    Nu nu;

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
        TypeTokenFinder finder = nu.nu(DefaultTypeTokenFinder.class, iface);
        Type instance = collections.find(interfaces, finder);
        return nu.nu(DefaultTypeInstance.class, instance);
    }
}
