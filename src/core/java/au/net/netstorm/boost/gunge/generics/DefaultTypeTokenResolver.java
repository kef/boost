package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.Type;

import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.nursery.autoedge.utils.DefaultTypeTokenFinder;
import au.net.netstorm.boost.nursery.autoedge.utils.TypeTokenFinder;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultTypeTokenResolver implements TypeTokenResolver {
    FunctionalCollection collections;
    Nu nu;

    public TypeTokenInstance resolve(Class<?> token, Class<?>... tokenInterfaces) {
        Class<?> tokenInterface = matchTokenInterface(token, tokenInterfaces);
        TypeTokenInstance instance = find(token, tokenInterface);
        return instance;
    }

    private Class<?> matchTokenInterface(Class<?> token, Class<?>... tokenInterfaces) {
        for (Class<?> tokenInterface : tokenInterfaces) {
            if (tokenInterface.isAssignableFrom(token)) return tokenInterface;
        }
        throw new RuntimeException("Can not resolve type from token.");
    }

    private TypeTokenInstance find(Class<?> token, Class<?> tokenInterface) {
        Type[] interfaces = token.getGenericInterfaces();
        TypeTokenFinder finder = nu.nu(DefaultTypeTokenFinder.class, tokenInterface);
        Type instance = collections.find(interfaces, finder);
        return nu.nu(DefaultTypeTokenInstance.class, instance);
    }
}
