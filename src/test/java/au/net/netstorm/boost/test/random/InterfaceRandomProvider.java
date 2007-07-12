package au.net.netstorm.boost.test.random;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.test.core.Provider;
import au.net.netstorm.boost.test.specific.Targetted;
import au.net.netstorm.boost.util.type.Data;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

// FIX 2076 Drive this out
public final class InterfaceRandomProvider implements Provider {
    private final Provider randomProvider;
    private final Targetted specificProviders;
    private final ClassMaster classMaster = new DefaultClassMaster();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public InterfaceRandomProvider(Provider randomProvider, Targetted specificProviders) {
        this.randomProvider = randomProvider;
        this.specificProviders = specificProviders;
    }

    public boolean canProvide(Class type) {
        return type.isInterface();
    }

    public Object provide(Class type) {
        // FIX 2076 Strongly typed exception with message.
        if (!canProvide(type)) throw new IllegalStateException("Cannot provide instance of type " + type);
        if (isSpecific(type)) return specific(type);
        if (isData(type)) return data(type);
        return mock(type);
    }

    // FIX BREADCRUMB 2076 Tidy up below.

    private Object mock(Class type) {
        // FIX 2076 We're totally missing the verify action.  WHICH IS IMPORTANT!!!!!!!!!!!!!.
        MockObjectTestCase mocker = new MockObjectTestCase() {
        };
        Mock mock = mocker.mock(type);
        return mock.proxy();
    }

    private Object data(Class type) {
        String defaultClassName = createImplName(type);
        Class implClass = loadImpl(defaultClassName, type);
        Constructor[] constructors = implClass.getConstructors();
        // FIX 2076 Use ClassMaster?
        if (constructors.length != 1) {
            // FIX 2076 Strongly typed exception with message.
            throw new IllegalStateException("There should only be one constuctor for " + implClass);
        }
        return createRandomInstance(constructors[0]);
    }

    private String createImplName(Class type) {
        String packageName = classMaster.getPackageName(type);
        String className = classMaster.getShortName(type);
        // FIX 2076 Change to " + Data".
        return packageName + ".Default" + className;
    }

    private Class loadImpl(String defaultClassName, Class type) {
        try {
            return Class.forName(defaultClassName);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot load default implementation for " + type, e);
        }
    }

    private Object createRandomInstance(Constructor constructor) {
        Class[] paramTypes = constructor.getParameterTypes();
        Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            params[i] = randomProvider.provide(paramTypes[i]);
        }
        return edgeConstructor.newInstance(constructor, params);
    }

    // FIX 2076 This belongs in a utility.
    private boolean isData(Class type) {
        if (!Data.class.isAssignableFrom(type)) return false;
        String implName = createImplName(type);
        try {
            Class.forName(implName);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private boolean isSpecific(Class type) {
        return specificProviders.canProvide(type);
    }

    private Object specific(Class type) {
        return specificProviders.provide(type);
    }
}
