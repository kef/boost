package au.net.netstorm.boost.reflect;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.type.Interface;

public class DefaultClassTestUtil implements ClassTestUtil {
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final ReflectEdge reflectEdge = new DefaultReflectEdge();
    private static final Object[] NO_PARAMETERS = {};

    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        Class type = targetInterface.getType();
        return isAssignable(type, cls);
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        return isAssignable(superClass, subClass);
    }

    public boolean isSubInterfaceOf(Interface superInterface, Interface subInterface) {
        Class superType = superInterface.getType();
        Class subType = subInterface.getType();
        return isAssignable(superType, subType);
    }

    private boolean isAssignable(Class superType, Class subType) {
        return superType.isAssignableFrom(subType);
    }

    public Object newInstance(Class type) {
        Constructor constructor = reflector.getConstructor(type);
        constructor.setAccessible(true);
        return reflectEdge.newInstance(constructor, NO_PARAMETERS);
    }
}
