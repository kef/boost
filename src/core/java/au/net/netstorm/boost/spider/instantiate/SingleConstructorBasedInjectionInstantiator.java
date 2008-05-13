package au.net.netstorm.boost.spider.instantiate;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.bullet.mirror.DefaultReflectMaster;
import au.net.netstorm.boost.bullet.mirror.ReflectMaster;
import au.net.netstorm.boost.gunge.type.DefaultBaseReference;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeConstructor;

public final class SingleConstructorBasedInjectionInstantiator implements Instantiator {
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public UnresolvedInstance instantiate(Implementation impl, Object[] parameters) {
        Constructor constructor = getConstructor(impl);
        checkArgs(impl, constructor, parameters);
        return instantiate(constructor, parameters, impl);
    }

    private Constructor getConstructor(Implementation impl) {
        Class cls = impl.getImpl();
        Constructor constructor = reflectMaster.getConstructor(cls);
        constructor.setAccessible(true);
        return constructor;
    }

    private void checkArgs(Implementation impl, Constructor constructor, Object[] parameters) {
        Class[] paramTypes = constructor.getParameterTypes();
        checkArgs(impl, paramTypes.length, parameters.length);
    }

    private void checkArgs(Implementation impl, int expected, int supplied) {
        if (expected != supplied) boom(impl, expected, supplied);
    }

    private void boom(Implementation impl, int expected, int supplied) {
        String message = "Expected " + expected + " parameters, given " + supplied + " in constructor for " + impl;
        throw new InstantiationException(message);
    }

    private UnresolvedInstance instantiate(Constructor constructor, Object[] parameters, Implementation impl) {
        Object ref = tryInstantiate(constructor, parameters, impl);
        return new DefaultBaseReference(ref);
    }

    private Object tryInstantiate(Constructor constructor, Object[] parameters, Implementation impl) {
        try {
            return edgeConstructor.newInstance(constructor, parameters);
        } catch (IllegalArgumentException e) {
            throw new InstantiationException("Unable to construct a " + impl, e);
        }
    }
}
