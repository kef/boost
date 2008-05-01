package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.Type;

import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.nursery.autoedge.utils.DefaultTypeTokenFinder;
import au.net.netstorm.boost.nursery.autoedge.utils.TypeTokenFinder;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultTypeTokenResolver implements TypeTokenResolver {
    FunctionalCollection collections;
    Nu nu;

    public TypeTokenInstance resolve(Class<?> tokenInterface, Class<?> token) {
        if (!tokenInterface.isAssignableFrom(token)) fail();
        TypeTokenInstance instance = find(tokenInterface, token);
        return instance;
    }

    private TypeTokenInstance find(Class<?> tokenInterface, Class<?> token) {
        Type[] interfaces = token.getGenericInterfaces();
        TypeTokenFinder finder = nu.nu(DefaultTypeTokenFinder.class, tokenInterface);
        Type instance = collections.find(interfaces, finder);
        return nu.nu(DefaultTypeTokenInstance.class, instance);
    }

    private void fail() {
        throw new RuntimeException("Can not resolve type from token.");
    }
}
