package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeConstructor;

// FIX 2318 This stinky little dog turd has to go ... WAZZA.
public final class DefaultInstantiatorWithProvider implements InstantiatorWithProvider {
    // FIX 2290 InstantiatorWithProvider smells real bad.  Sort this out.
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
