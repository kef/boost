package au.net.netstorm.boost.spider.instantiate;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class SingleConstructorBasedInjectionInstantiator implements Instantiator {
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public UnresolvedInstance instantiate(Implementation impl, Object[] parameters) {
        Constructor constructor = getConstructor(impl, parameters);
        Object ref = tryInstantiate(constructor, parameters, impl);
        return new DefaultBaseReference(ref);
    }

    private Constructor getConstructor(Implementation impl, Object[] parameters) {
        Constructor constructor = prepareConstructor(impl);
        checkArgs(impl, constructor, parameters);
        return constructor;
    }

    private Constructor prepareConstructor(Implementation impl) {
        Class cls = impl.getImpl();
        Constructor constructor = reflectMaster.getConstructor(cls);
        constructor.setAccessible(true);
        return constructor;
    }

    private void checkArgs(Implementation impl, Constructor constructor, Object[] parameters) {
        Class[] expectedParams = constructor.getParameterTypes();
        checkArgs(impl, expectedParams.length, parameters.length);
    }

    private void checkArgs(Implementation impl, int expected, int supplied) {
        if (expected != supplied) boom(impl, expected, supplied);
    }

    private void boom(Implementation impl, int expected, int supplied) {
        String message = "Expected " + expected + " parameters, given " + supplied + " in constructor for " + impl;
        throw new InstantiationException(message);
    }

    private Object tryInstantiate(Constructor constructor, Object[] parameters, Implementation impl) {
        try {
            return edgeConstructor.newInstance(constructor, parameters);
        } catch (IllegalArgumentException e) {
            throw new InstantiationException("Unable to construct a " + impl, e);
        }
    }
}
