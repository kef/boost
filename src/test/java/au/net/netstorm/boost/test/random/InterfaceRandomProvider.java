package au.net.netstorm.boost.test.random;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;
import au.net.netstorm.boost.util.type.Data;

// FIX 2076 Drive this out
public final class InterfaceRandomProvider implements RandomProvider {
    private final RandomProvider randomProvider;
    private final SpecificProviderRegistry specificProviders;
    private final ClassMaster classMaster = new DefaultClassMaster();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private EdgeClass edgeClass = new DefaultEdgeClass();

    public InterfaceRandomProvider(RandomProvider randomProvider, SpecificProviderRegistry specificProviders) {
        this.randomProvider = randomProvider;
        this.specificProviders = specificProviders;
    }

    public boolean canProvide(Class type) {
        if (!type.isInterface()) return false;
        return canCreateImplementation(type);
    }

    public Object provide(Class type) {
        return getImplementation(type);
    }

    private boolean canCreateImplementation(Class type) {
        boolean hasSpecific = specificProviders.canProvide(type);
        boolean isData = Data.class.isAssignableFrom(type);
        boolean hasImpl = hasImpl(type);
        return hasSpecific || (isData && hasImpl);
    }

    private Object getImplementation(Class type) {
        // FIX 2076 Strongly typed exception with message.
        if (!canProvide(type)) throw new IllegalStateException("Cannot provide instance of type " + type);
        if (specificProviders.canProvide(type)) return specificProviders.provide(type);
        return createDefaultInstance(type);
    }

    private Object createDefaultInstance(Class type) {
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
    private boolean hasImpl(Class type) {
        String implName = createImplName(type);
        try {
            Class.forName(implName);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
