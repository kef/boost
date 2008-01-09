package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.provider.Provider;

import java.lang.reflect.Constructor;

public final class DefaultInstantiatorWithProvider implements InstantiatorWithProvider {
    private final EdgeConstructor edger = new DefaultEdgeConstructor();
    private final ReflectMaster reflector = new DefaultReflectMaster();

    public Object createInstance(Class implClass, Provider provider) {
        Constructor constructor = reflector.getConstructor(implClass);
        return createInstance(constructor, provider);
    }

    private Object createInstance(Constructor constructor, Provider provider) {
        Class[] paramTypes = constructor.getParameterTypes();
        Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            params[i] = provider.provide(paramTypes[i]);
        }
        constructor.setAccessible(true);
        return edger.newInstance(constructor, params);
    }
}
