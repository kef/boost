package au.net.netstorm.boost.test.random;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.ProviderException;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.test.automock.AutoMocker;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.util.type.Data;

// FIX 2076 Drive this out
public final class InterfaceRandomProvider implements SpecificProvider {
    private final Provider randomProvider;
    private final DataProviders specificProviders;
    private final ClassMaster classMaster = new DefaultClassMaster();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final AutoMocker mocker;

    public InterfaceRandomProvider(Provider randomProvider, DataProviders specificProviders, AutoMocker mocker) {
        this.randomProvider = randomProvider;
        this.specificProviders = specificProviders;
        this.mocker = mocker;
    }

    public boolean canProvide(Class type) {
        return type.isInterface();
    }

    public Object provide(Class type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        if (isSpecific(type)) return specific(type);
        if (isData(type)) return data(type);
        return mock(type);
    }

    // FIX BREADCRUMB 2076 Tidy up below.

    private Object mock(Class type) {
        return mocker.mock(type);
    }

    private Object data(Class type) {
        String defaultClassName = createImplName(type);
        Class implClass = loadImpl(defaultClassName, type);
        Constructor[] constructors = implClass.getConstructors();
        // FIX 2076 Use ClassMaster?
        if (constructors.length != 1) {
            throw new ProviderException("There should be exactly one public constuctor" + implClass);
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
            throw new ProviderException("Cannot load default implementation for " + type, e);
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
